package ru.job4j.lambda

class HtmlTable {
    fun table(row : Int, cell : Int) : String {
        val table = StringBuilder().apply {
            append("<table>\n")
            for (r in 0 until row) {
                append("<tr>\n")
                for (c in 0 until cell) {
                    append("<td></td>\n")
                }
                append("</tr>\n")
            }
            append("</table>\n")
        }
        return table.toString()
    }
}

fun main() {
    print(HtmlTable().table(3, 2))
}