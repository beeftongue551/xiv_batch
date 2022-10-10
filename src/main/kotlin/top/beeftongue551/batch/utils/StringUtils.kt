package top.beeftongue551.batch.utils

class StringUtils {
    companion object {
        fun toList(string: String) : List<String> {
            var tempString = string
            tempString = tempString.substring(1)
            tempString = tempString.substring(0, tempString.length-1)
            return tempString.split(",")
        }
    }
}