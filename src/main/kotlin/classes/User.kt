package classes

data class User(
    val id: Int,
    val name: String,
    val address: String,
) {
    operator fun plus(another: User): User {
        return copy(another.id)
    }

}

fun main() {
    val user = User(1, "Robert", "Yerevan")

    val user2 = user.copy(
        address = "Gyumri"
    )

    user + user2

//    println(user)
//    println(user2)
//    println(user == user2)

    val (first, second) = Pair(1, "b")

    val (id, name, address) = user

//    println("$first, $second")
//    println(name)

    val s1 = "abc"
    val s2 = "b"
    println(s1 - s2)
}

operator fun String.minus(s: String): String {
    return replace(s, "")
}