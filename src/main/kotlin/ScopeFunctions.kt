
class City(
    val name: String,
    val street: String,
    val apt: String?,
)

class Person(
    val name: String,
    var age: Int,
    var city: City,
) {
    fun moveTo(anotherCity: City) {
        city = anotherCity
    }

    fun incrementAge() {
        age++
    }

    override fun toString(): String {
        return "$name, $age, $city"
    }
}

fun Int.extension() {

}

fun test(x: Int) {
    print(x * x)
    x.extension()
}

var foo: (Int) -> String = test@{
    if (it < 0) {
        return@test "-1"
    }
    it.toString()
}

fun main() {
    val person: Person = Person("Alice", 20, City("Amsterdam", "Amsterdam", null))

//    person.let {
//        println(it)
//        "it".let {
//            it.length
//        }
//        it.moveTo("London")
//        it.incrementAge()
//        println(it)
//    }
//
//    person.run {
//        println(this)
//        moveTo("London")
//        incrementAge()
//        println(this)
//    }
//
//    val x = 5
//    println(x * x)
//    x.extension()

//    println(person)
//    person.apply {
//        moveTo("Yerevan")
//        incrementAge()
//    }
//    println(person)

//    var a = "1"
//    var b = "2"
//
//    a = b.also { b = a }
//    println("$a, $b")

    testFoo(person)
}

fun testFoo(person: Person?) {
    person?.run {
        println(city.name)
    } ?: println("Person is null")

    println(person?.city?.name)

    with(person) {
        this?.incrementAge()
    }
}
