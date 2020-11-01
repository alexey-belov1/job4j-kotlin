package ru.job4j.safe

/**
 * Bank service
 */
class BankService {
    private val users = HashMap<User, ArrayList<Account>>()

    /**
     * Add [user] in bank service
     */
    fun addUser(user : User) {
        users.putIfAbsent(user, ArrayList())
    }

    /**
     * Return [Account] with [requisite] owned by the [User] with [passport] if it finds,
     * or else return null
     */
    fun findByRequisite(passport : String, requisite : String) : Account? =
        findByPassport(passport)?.let { user ->
            users[user]?.find { it.requisite == requisite }
        }

    /**
     * Add [account] to [User] if it finds by [passport]
     */
    fun addAccount(passport : String, account : Account) {
        findByPassport(passport)?.let { user ->
            users[user]?.add(account)
        }
    }

    /**
     * Return [User] if it finds by [passport],
     * or else return null
     */
    fun findByPassport(passport : String) : User? = users.keys.find { it.passport == passport }


    /**
     * Transfer the [amount] of the money
     * from [Account] with [srcRequisite] owned by the [User] with [srcPassport]
     * to [Account] with [descRequisite] owned by the [User] with [destPassport]
     */
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