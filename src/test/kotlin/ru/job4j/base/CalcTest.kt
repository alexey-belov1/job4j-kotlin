package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CalcTest : StringSpec({
    "1 + 1 = 2" {
        add(1.0, 1.0) shouldBe 2.0
    }

    "3 - 1 = 2" {
        subtract(3.0, 1.0) shouldBe 2.0
    }

    "2 * 3 = 6" {
        multiply(2.0, 3.0) shouldBe 6.0
    }

    "6 / 2 = 3" {
        div(6.0, 2.0) shouldBe 3.0
    }

    "max from 1 and 2 is 2" {
        max(1.0, 2.0) shouldBe 2.0
    }

    "max from 1, 2 and 3 is 3" {
        max(1.0, 2.0, 3.0) shouldBe 3.0
    }
})