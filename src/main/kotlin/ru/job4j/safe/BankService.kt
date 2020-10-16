package ru.job4j.safe

class BankService {
    private val users = HashMap<User, ArrayList<Account>>()

    fun addUser(user : User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByRequisite(passport : String, requisite : String) : Account? {
        val user = findByPassport(passport)
        return users[user]?.find { it -> it.requisite == requisite }
    }

    fun addAccount(passport : String, account : Account) {
        val user = findByPassport(passport)
        users[user]?.add(account)
    }

    fun findByPassport(passport : String) = users.keys.find { it.passport == passport }


    fun transferMoney(
        srcPassport : String, srcRequisite : String,
        destPassport : String, descRequisite : String, amount : Double
    ) : Boolean {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, descRequisite)
        return if (source != null && dest != null) {
            source.balance -= amount
            dest.balance += amount
            true
        } else false
    }
}

fun main() {
    val bank = BankService()
    bank.addUser(User("6655", "Alexey Belov"))
    var user = bank.findByPassport("66551")
    println(user?.name)
    user = bank.findByPassport("6655")
    println(user?.name)
}