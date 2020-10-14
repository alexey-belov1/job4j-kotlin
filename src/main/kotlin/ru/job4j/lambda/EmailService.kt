package ru.job4j.labmda

import ru.job4j.lambda.Message
import java.lang.StringBuilder

class EmailService {
    fun emailTo(message : Message): String {
        return with(StringBuilder()) {
            append("Subject : ").append(message.email)
            append("Body : ").append("Hello, ").append(message.email).append(" ")
            append("You win!")
        }.toString()
    }
}