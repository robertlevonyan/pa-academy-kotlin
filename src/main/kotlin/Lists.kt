fun main() {
    val l = listOf(1, 2, 3, 4, 5)
        .map { "$it" }
//        .filter { it.isNotEmpty() }

    val l2 = listOf("a", "b", "c")

    l / l2

    l.takeUnless { it.isEmpty() }?.run {

    }
}

operator fun <T> List<T>.div(list: List<T>) {

}