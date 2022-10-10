package top.beeftongue551.batch.repository

import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL
import org.springframework.stereotype.Repository
import top.beeftongue551.batch.entity.XivItem

@Mapper
@Repository
interface XivItemRepository {

    @InsertProvider(type = XivItemProvider::class)
    fun insertItem(items: List<XivItem>)

    @DeleteProvider(type = XivItemProvider::class)
    fun deleteTable()

    class XivItemProvider : ProviderMethodResolver {
        companion object {
            @JvmStatic
            fun deleteTable(): String {
                return SQL().DELETE_FROM("M_XIV_ITEM").toString()
            }

            @JvmStatic
            fun insertItem(items: List<XivItem>): String {
                var sql = SQL().INSERT_INTO("M_XIV_ITEM")
                    .INTO_COLUMNS("Id", "Name", "Icon",
                        "ItemLevel", "ItemUICategory", "ItemSearchCategory",
                        "EquipSlotCategory", "ItemSortCategory", "EquipLevel",
                        "EquipRestriction", "ClassJobCategory", "Marketable"
                    )

                repeat(items.size){
                    sql = sql.INTO_VALUES("#{items[$it].id}", "#{items[$it].name}", "#{items[$it].icon}",
                        "#{items[$it].itemLevel}", "#{items[$it].itemUICategory}", "#{items[$it].itemSearchCategory}",
                        "#{items[$it].equipSlotCategory}", "#{items[$it].itemSortCategory}", "#{items[$it].equipLevel}",
                        "#{items[$it].equipRestriction}", "#{items[$it].classJobCategory}", "#{items[$it].marketable}"
                    )
                    if (it != items.size - 1) {
                        sql = sql.ADD_ROW()
                    }
                }

                return sql.toString()
            }
        }
    }
}