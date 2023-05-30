package problems

import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

typealias MyLambda = (String) -> Unit

fun main() {
//    println(f167(0))
//    println(f173(3, 4f, 19f))
//    println(f185(10))

//    println(f188_1(13))
//    println(f188_2(8))

//    println(131.isPrimeNumber())
//    println(121.isPrimeNumber2())

//    println(1358.elementAt(1))

    println(f175(5))
}

fun Int.elementAt(index: Int): Int {
    var element: Int
    var count = 0
    var size = 0
    do {
        val factor = 10.toFloat().pow((size + 1)).toInt()
        element = this % factor
        size++
    } while (element < this)
    do {
        val factor1 = 10.toFloat().pow(size - count).toInt()
        val factor2 = 10.toFloat().pow(size - count - 1).toInt()
        element = this % factor1 / factor2
        count++
    } while (count <= index)

    return element
}

fun f167(x: Int): Boolean = (1..30)
    .any { sin(x.toFloat().pow(it)) < 0 }

fun f173(n: Int, a: Float, b: Float): Float {
    if (n < 1 || a > b) return -1f

    val h = (b - a) / n

    repeat(n) { next ->
        print(a + next * h)
        print(" ")
    }
    print(b)
    println()

    return h
}

fun f175(n: Int) {
    var x = 1f
    val data = mutableListOf<Float>()
    (1..n).forEach(action = { index ->
        x = (x + 1) / index
        data.add(x)
    })
    println(data)
}

fun test(action: MyLambda) {
    var unit: Unit = action("")
}

fun f185(p: Int) {
    if (p !in 1 until 25) {
        println("Wrong percent")
        return
    }

    var x = 30_000
    var m = 0;
    do {
        x += x * p / 100
        m++
    } while (x < 100_000)

    println("Total $x AMD in $m months")
}

fun f188_1(n: Int): Boolean {
    var x = 2
    var currentFibNumber = fib(x++)
    while (currentFibNumber < n) {
        currentFibNumber = fib(x++)
    }
    return currentFibNumber == n
}

fun fib(x: Int): Int {
    if (x <= 2) return 1
    return (fib(x - 1) + fib(x - 2))
}

fun f188_2(n: Int): Boolean {
    val value = 5 * n * n
    return (value + 4).isPerfectSquare() ||
            (value - 4).isPerfectSquare()
}

fun Int.isPerfectSquare(): Boolean {
    val sqrt = sqrt(toFloat())
    return sqrt - sqrt.toInt() == 0.0f
}

fun Int.isPrimeNumber(): Boolean =
    !(2..sqrt(this.toFloat()).toInt())
        .any { this % it == 0 }

fun Int.isPrimeNumber2(): Boolean =
    ((this - 1) / 6f).isNaturalNumber() ||
            ((this + 1) / 6f).isNaturalNumber()

fun Float.isNaturalNumber(): Boolean =
    this - toInt() == 0.0f
