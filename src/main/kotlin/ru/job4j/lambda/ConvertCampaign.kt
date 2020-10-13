package ru.job4j.lambda

import java.time.LocalDate

fun campaignsToString(campaigns : List<Campaign>) : List<String> {
    return campaigns.map {
        "Name: ${it.name}, " +
                "City: ${it.address.city}, Street: ${it.address.street}, Home: ${it.address.home}, " +
                "Created: ${it.created.month}.${it.created.year}"
    }
}

fun main() {
    val campaign = Campaign(
        "Google",
        Address("Moscow", "Arbat", 10),
        LocalDate.of(2015, 1, 1)
    )
    println(campaignsToString(listOf(campaign)))
}