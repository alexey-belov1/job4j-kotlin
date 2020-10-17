package ru.job4j.safe

class BankService {
    private val users = HashMap<User, ArrayList<Account>>()

    fun addUser(user : User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByRequisite(passport : String, requisite : String) : Account? =
        findByPassport(passport)?.let { user ->
            users[user]?.find { it.requisite == requisite }
        }

    fun addAccount(passport : String, account : Account) {
        findByPassport(passport)?.let { user ->
            users[user]?.add(account)
        }
    }

    fun findByPassport(passport : String) : User? = users.keys.find { it.passport == passport }


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