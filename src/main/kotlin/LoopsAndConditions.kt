fun main() {
    val x = getX()
    val y = false
    val z = "abc"

//    when {
//        x > 5 -> println("1")
//        y -> println("2")
//        z.isNotEmpty() -> println("3")
//    }

    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)

    for ((index, element) in array.withIndex()) {
        print("$index: $element")
        println()
        if (index >= 4) break
    }

    array.forEach { element ->

    }
    array.forEachIndexed { index, element ->
        if (index >= 4) return@forEachIndexed
    }
}

fun getX() = 10
