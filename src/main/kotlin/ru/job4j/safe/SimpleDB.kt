package ru.job4j.safe

import ru.job4j.tracker.Item
import java.sql.Connection
import java.sql.DriverManager
import kotlin.collections.ArrayList

class SimpleDB {

    private lateinit var connection : Connection
    private lateinit var queries : Map<String, (String) -> String>

    fun init() {
        this.connection = DriverManager.getConnection(
            "jdbc:postgresql://127.0.0.1:5432/kt",
            "postgres",
            "password"
        ).apply {

            val select = { sql : String ->
                val list = ArrayList<Item>()
                createStatement().executeQuery(sql).use { rs ->
                    while (rs.next()) {
                        list.add(
                            Item(
                                rs.getString("id"),
                                rs.getString("name")
                            )
                        )
                    }
                }
                "Perform query 'select': $sql. Result: $list"
            }

            val insert = { sql : String ->
                createStatement().executeUpdate(sql)
                "Perform query 'insert': $sql"
            }

            val update = { sql : String ->
                createStatement().executeUpdate(sql)
                "Perform query 'update': $sql"
            }

            val delete = { sql : String ->
                createStatement().executeUpdate(sql)
                "Perform query 'delete': $sql"
            }

            queries = mapOf(
                "insert" to insert,
                "select" to select,
                "update" to update,
                "delete" to delete
            )
        }
    }

    fun exec(sql : String) : String =
        queries.keys.find { sql.contains(it) }.let { key -> queries[key]?.invoke(sql) }
            ?: "Unable to complete the query"
}

fun main() {
    val db = SimpleDB()
    db.init()
    println(db.exec("delete from item *"))
    println(db.exec("insert into item(name) values ('item1')"))
    println(db.exec("insert into item(name) values ('item2')"))
    println(db.exec("insert into item(name) values ('item3')"))
    println(db.exec("update item set name = 'item2updated' where name = 'item2'"))
    println(db.exec("delete from item where name = 'item3'"))
    println(db.exec("select * from item"))
}

