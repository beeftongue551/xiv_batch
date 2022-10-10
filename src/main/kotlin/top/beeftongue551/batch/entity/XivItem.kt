package top.beeftongue551.batch.entity


import com.orangesignal.csv.annotation.CsvColumn
import com.orangesignal.csv.annotation.CsvEntity
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@CsvEntity
@Table
@Entity
data class XivItem(
    @Id
    @CsvColumn(name = "#")
    val id: String,

    @CsvColumn(name = "Singular")
    val name: String,

    @CsvColumn(name = "Icon")
    var icon: String,

    @CsvColumn(name = "Level{Item}")
    val itemLevel: String,

    @CsvColumn(name = "ItemUICategory")
    val itemUICategory: String,

    @CsvColumn(name = "ItemSearchCategory")
    val itemSearchCategory: String,

    @CsvColumn(name = "EquipSlotCategory")
    val equipSlotCategory: String,

    @CsvColumn(name = "ItemSortCategory")
    val itemSortCategory: String,

    @CsvColumn(name = "Level{Equip}")
    val equipLevel: String,

    @CsvColumn(name = "EquipRestriction")
    val equipRestriction: String,

    @CsvColumn(name = "ClassJobCategory")
    val classJobCategory: String,

    var marketable: Boolean = false
)
