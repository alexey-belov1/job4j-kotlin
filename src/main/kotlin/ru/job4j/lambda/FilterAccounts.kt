package ru.job4j.lambda

fun filterAccountsByNameAndBalance(accounts : List<Account>) : List<Account> {
    return accounts.filter { it.name.contains("Ivan") && it.balance > 0 }
}