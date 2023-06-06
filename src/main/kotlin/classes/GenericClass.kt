package classes

import classes.delegation.ImmutableDelegation

class GenericClass<T, M>(
    val first: T,
    val second: M,
    val third: String,
) {

    fun getT(): T? {
        return null
    }

    fun calculateM(m: M) {

    }
}
