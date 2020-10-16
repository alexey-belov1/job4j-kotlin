package ru.job4j.safe

import java.time.LocalDate

fun generatePurchasesInHtml(purchases : List<Purchase>) =
    StringBuilder().apply {
        append("<table>\n")
        purchases.forEach() {
            append("<tr>\n")
            append("<td> ${it.name} </td>\n")
            append("<td> ${it.created} </td>\n")
            append("<td> ${it.address ?: ""} </td>\n")
            append("</tr>\n")
        }
        append("</table>\n")
    }

fun main() {
    val purchase1 = Purchase(
        "Notebook",
        LocalDate.of(2020, 10, 15),
        Address("Arbat", "10", 666333)
    )
    val purchase2 = Purchase(
        "Phone",
        LocalDate.of(2020, 10, 16)
    )
    print(generatePurchasesInHtml(listOf(purchase1, purchase2)))
}
