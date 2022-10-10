package top.beeftongue551.batch.utils

import com.orangesignal.csv.CsvConfig
import com.orangesignal.csv.manager.CsvEntityManager
import java.io.File


class CsvUtils {
    companion object {
        fun <T> openCsv(filePath: String, clazz: Class<T>) : List<T> {

            val csvFile = File(filePath)
            val cfg = CsvConfig()
            return CsvEntityManager(cfg).load(clazz).from(csvFile)
        }
    }
}