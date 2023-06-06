package classes.delegation

fun main() {
    val list = listOf(1, 2, 3, 4, 5)

    list.asSequence()
        .filter { it > 0 }
        .map { it.toString() }
        .filter { it.isNotEmpty() }
        .drop(2)
        .toList()
}