package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class DegragmentTest : StringSpec({
    "[null, h, e, null, l, l, o] -> [h, e, l, l, o, null, null]" {
        val array = arrayOf(null, "h", "e", null, "l", "l", "o")
        defragment(array)
        array shouldBe arrayOf("h", "e", "l", "l", "o", null, null)
    }
})