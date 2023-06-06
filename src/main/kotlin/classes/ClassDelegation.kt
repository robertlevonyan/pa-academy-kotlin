package classes

interface TestTest {
    fun f1()

    fun f2()
}

class First: TestTest {
    override fun f1() {
        println("f1")
    }

    override fun f2() {
        println("f2")
    }
}

class Second(private val first: First): TestTest by first
