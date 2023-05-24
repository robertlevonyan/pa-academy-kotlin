import classes.Request

fun main() {
    val list = listOf(1, 2, 3)

    val swappedList = list.swap(1, 2)
    println(swappedList)

    val newList = list.toMutableList()
    val s = "abc"
    s.run {

    }
    s.let { s ->

    }
    newList.firstElement = 10

    println(newList)

    list.fold2(0) { acc, _ ->
        return@fold2 acc
    }
}

fun <T> List<T>.swap(first: Int, second: Int): List<T> {
    val mutableList = toMutableList()
    val firstElement = mutableList[first]
    val secondElement = mutableList[second]
    mutableList[first] = secondElement
    mutableList[second] = firstElement
    return mutableList
}

var <T> MutableList<T>.firstElement: T
    get() = first()
    set(value) {
        set(0, value)
    }

inline fun <T, R> Iterable<T>.fold2(initial: R, crossinline operation: (acc: R, T) -> R): R {
    var accumulator = initial
    Runnable { for (element in this@fold2) accumulator = operation(accumulator, element) }
    return accumulator
}
