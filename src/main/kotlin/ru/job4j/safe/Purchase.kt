package ru.job4j.safe

import java.time.LocalDate

data class Purchase(val name : String, val created : LocalDate, val address : Address? = null)