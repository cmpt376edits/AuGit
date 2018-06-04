// TODO add unittest, research Kotlin Test Frameworks

import java.io.*

object FileToString {
    /**
     * Returns a String containing all the characters from the file at filePath, with all the newlines and spaces
     * removed.
     *
     * @param filePath : String
     * @return String/null
     */
    fun convertToString(filePath: String): String? {
        val file = File(filePath)
        val s = StringBuilder()
        try {
            val `in` = BufferedReader(FileReader(file))
            var buf: String? = `in`.readLine()
            while (buf != null) {
                if (buf.trim { it <= ' ' } != "") {
                    s.append(buf.trim { it <= ' ' })
                    s.append(" ")
                }
                buf = `in`.readLine()
            }
            return s.toString()
        } catch (iox: IOException) {
            iox.printStackTrace()
        }

        return null
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val filePath = "/* Bring up Dialog Potentially to get file or use cwd */"
        val res = convertToString(filePath)
    }
}
