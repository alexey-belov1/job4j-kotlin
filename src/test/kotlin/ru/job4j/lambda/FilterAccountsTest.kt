package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FilterAccountsTest : StringSpec({
    "When filter accounts by name and balance" {
        val accounts = listOf(
            Account("Max K.", 100),
            Account("Ivan S.", 200),
            Account("Ivan P.", 0)
        )
        filterAccountsByNameAndBalance(accounts) shouldBe listOf(Account("Ivan S.", 200))
    }
})