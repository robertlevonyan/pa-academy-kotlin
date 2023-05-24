package classes

object Test {
    init {
        println("Init")
    }
    fun foo() {
        println("Hello world!")
    }
}

fun main() {
    Test.foo()
}