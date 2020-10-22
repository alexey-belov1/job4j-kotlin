package ru.job4j.dsl

import org.apache.commons.dbcp2.BasicDataSource

class BasicDataSourceBuilder {

    companion object Builder {
        private var driverField : String? = null
        private var urlField : String? = null
        private var usernameField : String? = null
        private var passwordField : String? = null
        private var minIdleField : Int? = null
        private var maxIdleField : Int? = null
        private var maxOPSTField : Int? = null

        fun driverClassName(driver : String) = apply { driverField = driver }

        fun url(url : String) = apply { urlField = url }

        fun username(username : String) = apply { usernameField = username }

        fun password(password : String) = apply { passwordField = password }

        fun minIdle(minIdle : Int) = apply { minIdleField = minIdle }

        fun maxIdle(maxIdle : Int) = apply { maxIdleField = maxIdle }

        fun maxOpenPreparedStatements(maxOPST : Int) = apply { maxOPSTField = maxOPST }

        fun build() : BasicDataSource = BasicDataSource().apply {
            driverField.let { driverClassName = it }
            urlField.let { url = it }
            usernameField.let { username = it }
            passwordField.let { password = it }
            if (minIdleField != null) minIdle = minIdleField!!
            if (maxIdleField != null) maxIdle = maxIdleField!!
            if (maxOPSTField != null) maxOpenPreparedStatements = maxOPSTField!!
        }
    }
}

fun main() {
    val pool = BasicDataSourceBuilder
        .driverClassName("org.postgres.Driver")
        .url("jdbc:postgresql://127.0.0.1:5432/kt")
        .username("postgres")
        .password("password")
        .minIdle(5)
        .maxIdle(10)
        .maxOpenPreparedStatements(100)
        .build()

    pool.apply {
        println(
            driverClassName + "\n"
                    + url + "\n"
                    + username + "\n"
                    + password + "\n"
                    + minIdle + "\n"
                    + maxIdle + "\n"
                    + maxOpenPreparedStatements
        )
    }
}