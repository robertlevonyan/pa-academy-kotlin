package classes.delegation

abstract class TestDelegation {
    val attributes = mutableMapOf<String, Any>()
}

class Test1 : TestDelegation() {
    val attrValue: String by attribute(TEST_KEY)

    fun printSmth() {
        println(attrValue)
    }

    fun f2() {
        println(attrValue.length)
    }

    companion object {
        const val TEST_KEY = "TEST_KEY"
    }
}