package ru.job4j.dsl

import org.apache.commons.dbcp2.BasicDataSource
import ru.job4j.tracker.Item
import java.sql.ResultSet
import java.sql.Statement
import kotlin.collections.ArrayList

class Storage(private val pool : BasicDataSource) {

    fun <T> executeQuery(sql : String, block : ResultSet.() -> T?) : T? =
        execute { executeQuery(sql).use { it.block() } }

    fun executeUpdate(sql : String) : Int? =
        execute { executeUpdate(sql) }

    fun executeUpdateWithGenerateKey(sql : String) : Int? =
        execute {
            executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)
            generatedKeys.use {
                if (it.next()) it.getInt(1) else null
            }
        }

    private fun <T> execute(block : Statement.() -> T?) : T? =
        pool.connection.use { con ->
            con.createStatement().use { st ->
                st.block()
            }
        }
}


fun Storage.add(item : Item) : Item = item.apply {
    id = executeUpdateWithGenerateKey("insert into item(name) values('${item.name}')").toString()
}

fun Storage.replace(id : String, item : Item) : Boolean =
    executeUpdate("update item set name = '${item.name}' where id = $id")!! > 0

fun Storage.delete(id : String) : Boolean =
    executeUpdate("delete from item where id = $id")!! > 0

fun Storage.findAll() : List<Item> =
    executeQuery("select * from item") {
        val list = ArrayList<Item>()
        while (next()) {
            list.add(
                Item(
                    id = getString("id"),
                    name = getString("name")
                )
            )
        }
        list
    }!!


fun Storage.findById(id : String) : Item? =
    executeQuery("select * from item where id = $id") {
        if (next())
            Item(
                id = getString("id"),
                name = getString("name")
            )
        else null
    }


fun Storage.findByName(name : String) : List<Item> =
    executeQuery("select * from item where name = '$name'") {
        val list = ArrayList<Item>()
        while (next()) {
            list.add(
                Item(
                    id = getString("id"),
                    name = getString("name")
                )
            )
        }
        list
    }!!

