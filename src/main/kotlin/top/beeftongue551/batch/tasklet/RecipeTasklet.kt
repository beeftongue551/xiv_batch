package top.beeftongue551.batch.tasklet

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import top.beeftongue551.batch.constants.RECIPE_CSV_PATH
import top.beeftongue551.batch.constants.RECIPE_LEVEL_TABLE_CSV_PATH
import top.beeftongue551.batch.entity.RecipeLevelTable
import top.beeftongue551.batch.entity.XivRecipe
import top.beeftongue551.batch.repository.XivRecipeRepository
import top.beeftongue551.batch.utils.CsvUtils

/**
 * M_XIV_RECIPE操作用のTaskletコンポーネント
 */
@Component
class RecipeTasklet : Tasklet {

    @Autowired
    lateinit var recipeRepository: XivRecipeRepository

    /**
     * 実行時にM_XIV_RECIPE内を削除し、データの再格納を行う
     *
     * @throws Exception thrown if error occurs during execution.
     */
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        println("recipeStep START")

        val recipes = CsvUtils.openCsv(RECIPE_CSV_PATH, XivRecipe::class.java)
        println("recipe.csv loaded")

        val recipeLevelTable = CsvUtils.openCsv(RECIPE_LEVEL_TABLE_CSV_PATH, RecipeLevelTable::class.java)
        println("RecipeLevelTable.csv loaded")

        recipes.forEachIndexed { index, recipe ->
            recipeLevelTable.forEach {
                if (it.id == (recipe.RecipeLevelTable?.replace("RecipeLevelTable#", "") ?: "")) {
                    recipes[index].RecipeLevelTable = it.classJobLevel
                }
            }
        }

        recipeRepository.deleteTable()
        println("M_XIV_RECIPE deleted")
        recipeRepository.insertRecipe(recipes)
        println("M_XIV_RECIPE inserted")

        println("recipeStep END")
        return RepeatStatus.FINISHED
    }
}