package top.beeftongue551.batch.entity

import com.orangesignal.csv.annotation.CsvColumn
import com.orangesignal.csv.annotation.CsvEntity
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * recipe.csvから取得したデータを格納するクラス
 */
@CsvEntity
@Table
@Entity
data class XivRecipe(
    @Id
    @CsvColumn(name = "#")
    val ID: String?,

    @CsvColumn(name = "Number")
    val Number: String?,

    @CsvColumn(name = "CraftType")
    val CraftType: String?,

    @CsvColumn(name = "RecipeLevelTable")
    var RecipeLevelTable: String?,

    @CsvColumn(name = "Item{Result}")
    val ItemResult: String?,

    @CsvColumn(name = "Amount{Result}")
    val AmountResult: String,

    @CsvColumn(name = "Item{Ingredient}[0]")
    val ItemIngredient0: String?,

    @CsvColumn(name = "Amount{Ingredient}[0]")
    val AmountIngredient0: String?,

    @CsvColumn(name = "Item{Ingredient}[1]")
    val ItemIngredient1: String?,

    @CsvColumn(name = "Amount{Ingredient}[1]")
    val AmountIngredient1: String?,

    @CsvColumn(name = "Item{Ingredient}[2]")
    val ItemIngredient2: String?,

    @CsvColumn(name = "Amount{Ingredient}[2]")
    val AmountIngredient2: String?,

    @CsvColumn(name = "Item{Ingredient}[3]")
    val ItemIngredient3: String?,

    @CsvColumn(name = "Amount{Ingredient}[3]")
    val AmountIngredient3: String?,

    @CsvColumn(name = "Item{Ingredient}[4]")
    val ItemIngredient4: String?,

    @CsvColumn(name = "Amount{Ingredient}[4]")
    val AmountIngredient4: String?,

    @CsvColumn(name = "Item{Ingredient}[5]")
    val ItemIngredient5: String?,

    @CsvColumn(name = "Amount{Ingredient}[5]")
    val AmountIngredient5: String?,

    @CsvColumn(name = "Item{Ingredient}[6]")
    val ItemIngredient6: String?,

    @CsvColumn(name = "Amount{Ingredient}[6]")
    val AmountIngredient6: String?,

    @CsvColumn(name = "Item{Ingredient}[7]")
    val ItemIngredient7: String?,

    @CsvColumn(name = "Amount{Ingredient}[7]")
    val AmountIngredient7: String?,

    @CsvColumn(name = "Item{Ingredient}[8]")
    val ItemIngredient8: String?,

    @CsvColumn(name = "Amount{Ingredient}[8]")
    val AmountIngredient8: String?,

    @CsvColumn(name = "Item{Ingredient}[9]")
    val ItemIngredient9: String?,

    @CsvColumn(name = "Amount{Ingredient}[9]")
    val AmountIngredient9: String?,

    @CsvColumn(name = "SecretRecipeBook")
    val SecretRecipeBook: String?,
)