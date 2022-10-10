package top.beeftongue551.batch.entity

import com.orangesignal.csv.annotation.CsvColumn
import com.orangesignal.csv.annotation.CsvEntity
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * RecipeLeveLTable.csvから取得したデータを格納するクラス
 */
@CsvEntity
@Table
@Entity
data class RecipeLevelTable(
    @Id
    @CsvColumn(name = "#")
    val id: String,

    @CsvColumn(name = "ClassJobLevel")
    val classJobLevel: String
)
