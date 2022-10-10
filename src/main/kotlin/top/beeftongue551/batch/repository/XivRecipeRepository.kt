package top.beeftongue551.batch.repository

import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL
import org.springframework.stereotype.Repository
import top.beeftongue551.batch.entity.XivRecipe

/**
 * M_XIV_RECIPE用の操作を行うためのレポジトリクラス
 */
@Mapper
@Repository
interface XivRecipeRepository {

    /**
     * M_XIV_RECIPE内の削除を行う
     */
    @DeleteProvider(type = XivRecipeProvider::class)
    fun deleteTable()

    @InsertProvider(type = XivRecipeProvider::class)
    fun insertRecipe(recipes: List<XivRecipe>)

    /**
     * M_XIV_RECIPE用のSQLProviderクラス
     */
    class XivRecipeProvider : ProviderMethodResolver {
        companion object {
            /**
             * 削除用SQLの生成
             */
            @JvmStatic
            fun deleteTable(): String {
                return SQL().DELETE_FROM("M_XIV_RECIPE").toString()
            }

            /**
             * Insert用SQLの生成
             *
             * @param recipes
             * @return
             */
            @JvmStatic
            fun insertRecipe(recipes: List<XivRecipe>): String {
                var sql = SQL().INSERT_INTO("M_XIV_RECIPE")
                    .INTO_COLUMNS(
                        "ID",
                        "Number",
                        "CraftType",
                        "RecipeLevelTable",
                        "ItemResult",
                        "AmountResult",
                        "SecretRecipeBook",
                        "ItemIngredient1",
                        "ItemIngredient2",
                        "ItemIngredient3",
                        "ItemIngredient4",
                        "ItemIngredient5",
                        "ItemIngredient6",
                        "ItemIngredient7",
                        "ItemIngredient8",
                        "ItemIngredient9",
                        "AmountIngredient1",
                        "AmountIngredient2",
                        "AmountIngredient3",
                        "AmountIngredient4",
                        "AmountIngredient5",
                        "AmountIngredient6",
                        "AmountIngredient7",
                        "AmountIngredient8",
                        "AmountIngredient9"
                    )

                repeat(recipes.size) {
                    sql = sql.INTO_VALUES(
                        "#{recipes[$it].ID}",
                        "#{recipes[$it].Number}",
                        "#{recipes[$it].CraftType}",
                        "#{recipes[$it].RecipeLevelTable}",
                        "#{recipes[$it].ItemResult}",
                        "#{recipes[$it].AmountResult}",
                        "#{recipes[$it].SecretRecipeBook}",
                        "#{recipes[$it].ItemIngredient1}",
                        "#{recipes[$it].ItemIngredient2}",
                        "#{recipes[$it].ItemIngredient3}",
                        "#{recipes[$it].ItemIngredient4}",
                        "#{recipes[$it].ItemIngredient5}",
                        "#{recipes[$it].ItemIngredient6}",
                        "#{recipes[$it].ItemIngredient7}",
                        "#{recipes[$it].ItemIngredient8}",
                        "#{recipes[$it].ItemIngredient9}",
                        "#{recipes[$it].AmountIngredient1}",
                        "#{recipes[$it].AmountIngredient2}",
                        "#{recipes[$it].AmountIngredient3}",
                        "#{recipes[$it].AmountIngredient4}",
                        "#{recipes[$it].AmountIngredient5}",
                        "#{recipes[$it].AmountIngredient6}",
                        "#{recipes[$it].AmountIngredient7}",
                        "#{recipes[$it].AmountIngredient8}",
                        "#{recipes[$it].AmountIngredient9}"
                    )
                    if (it != recipes.size - 1) {
                        sql = sql.ADD_ROW()
                    }
                }
                return sql.toString()
            }
        }
    }
}