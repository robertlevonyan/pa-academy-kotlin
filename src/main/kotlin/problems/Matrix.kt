package problems

fun createMatrix(size: Int): Array<Array<Int>> {
//    val array = Array(size) {
//        Array(size) {
//            (Math.random() * 10).toInt()
//        }
//    }

//    val array = arrayOf(
//        arrayOf(1, 5, 8, 3),
//        arrayOf(2, 0, 7, 8),
//        arrayOf(3, 4, 9, 5),
//    )
    val array = arrayOf(
        arrayOf(1, 8, 5),
        arrayOf(0, 2, 7),
        arrayOf(3, 4, 9),
    )

    return array
}

fun f491(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val max = matrix.maxOf { it.max() }

    val maxRowIndex = matrix.indexOfFirst { it.contains(max) }
    val maxColumnIndex = matrix[maxRowIndex].indexOf(max)

    return matrix.swapColumns(0, maxColumnIndex)
        .swapRows(0, maxRowIndex)
}

fun f501(matrix: Array<Array<Int>>): Array<Int> {
    return matrix.mapIndexed { indexRow, ints ->
        var sum = 1
        var indexSum = 0
        ints.forEachIndexed { indexColumn, i ->
            if (i % 2 == 0) {
                if (indexColumn == indexRow && i <= ints[indexRow]) {
                    indexSum += indexColumn
                    sum *= i
                }
            }
        }
        if (indexSum % 2 != 0) sum else 1
    }.toTypedArray()
}

fun Array<Array<Int>>.swapRows(first: Int, second: Int): Array<Array<Int>> {
    val temp = get(first)
    set(first, get(second))
    set(second, temp)
    return this
}

fun Array<Array<Int>>.swapColumns(first: Int, second: Int): Array<Array<Int>> {
    forEach { element ->
        val temp = element[first]
        element[first] = element[second]
        element[second] = temp
    }
    return this
}

fun main() {
    val matrix = createMatrix(10)
    println(matrix.joinToString("\n") { it.contentToString() })
    println("---")
//    println(f452(matrix))
//    println(f491(matrix).joinToString("\n") { it.contentToString() })
    println(f501(matrix).joinToString(", "))
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