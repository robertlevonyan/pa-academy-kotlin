package problems

fun createMatrix(size: Int): Array<Array<Int>> {
    val array = Array(size) {
        Array(size) {
            (Math.random() * 10).toInt()
        }
    }

    return array
}

fun main() {
    val matrix = createMatrix(4)
    println(matrix.joinToString("\n") { it.contentToString() })
    println("---")
    println(f452(matrix))
}

fun f452(matrix: Array<Array<Int>>): List<Int> {
    val list = mutableListOf<Int>()

    matrix.forEach { elementArray ->
        val first = elementArray.first()
        val last = elementArray.last()
        list.add(first * first + last * last)
    }

    return list
}