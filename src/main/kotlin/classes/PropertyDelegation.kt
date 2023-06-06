package classes

import classes.delegation.ImmutableDelegation
import classes.delegation.immutable
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class PropertyDelegation {
    val user by lazy {
        User(1, "Robert", "Yerevan")
    }

    var x by Delegates.observable(5) { _, old, new ->
        println("Observable - $old, $new")
    }

    var y by Delegates.vetoable(5) { _, old, new ->
        println("Vetoable - $old, $new")
        new > 0
    }

    var z by Delegates.notNull<Int>()

    val i by immutable()

    fun foo() {
        println(y)
        y = -100
        println(y)

        println(z)
//        println(i)
    }

    override fun toString(): String {
        return "Hello World!"
    }
}

fun main() {
    val propertyDelegation = PropertyDelegation()
    propertyDelegation.foo()
}