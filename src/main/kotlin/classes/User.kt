package classes

data class User(
    val id: Int,
    val name: String,
    val address: String,
)

fun main() {
    val user = User(1, "Robert", "Yerevan")

    val user2 = user.copy(
        address = "Gyumri"
    )

    println(user)
    println(user2)
    println(user == user2)

    val (first, second) = Pair(1, "b")

    val (id, name, address) = user

    println("$first, $second")
    println(name)
}