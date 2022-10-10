package top.beeftongue551.batch.tasklet

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import top.beeftongue551.batch.constants.ITEM_CSV_PATH
import top.beeftongue551.batch.constants.MARKETABLE_ITEM
import top.beeftongue551.batch.entity.XivItem
import top.beeftongue551.batch.repository.XivItemRepository
import top.beeftongue551.batch.utils.CsvUtils
import top.beeftongue551.batch.utils.StringUtils


@Component
class ItemTasklet :Tasklet {

    @Autowired
    lateinit var itemRepository: XivItemRepository


    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        println("itemStep start")
        val itemList = CsvUtils.openCsv(ITEM_CSV_PATH, XivItem::class.java)
        println("item.csv loaded")

        val rest = RestTemplate()
        val response = rest.getForEntity(MARKETABLE_ITEM, String::class.java)

        val json = response.body ?: return RepeatStatus.FINISHED

        val marketableItemId = StringUtils.toList(json)

        itemList.forEach {
            if (marketableItemId.contains(it.id)) {
                it.marketable = true
            }
            it.icon = it.icon.replace(".tex", ".png")
        }

        itemRepository.deleteTable()
        println("m_xiv_item deleted")
        itemRepository.insertItem(itemList)
        println("m_xiv_item inserted")
        println("itemStep end")
        return RepeatStatus.FINISHED
    }

}