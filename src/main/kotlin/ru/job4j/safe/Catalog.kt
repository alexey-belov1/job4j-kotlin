package ru.job4j.safe

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File


class Catalog {
    val cities : List<City> by lazy { loadCities() }

    private fun loadCities() : List<City> = ObjectMapper().readValue(
        File("catalog.json"),
        Array<City>::class.java
    ).toList()
}

fun main() {
    println(Catalog().cities)
}