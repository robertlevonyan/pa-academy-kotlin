package classes

fun main() {
    val demo = InitOrderDemo("0")
    demo.name
}

class InitOrderDemo(val name: String) {

    fun test() {
        print(name)
    }
}
