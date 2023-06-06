package classes.delegation

import java.lang.IllegalArgumentException
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class AttributeDelegation<T>(
    private val key: String,
    private val type: Class<T>,
) : ReadOnlyProperty<TestDelegation, T> {
    override fun getValue(
        thisRef: TestDelegation,
        property: KProperty<*>,
    ): T {
        return when (type) {
            String::class.java -> thisRef.attributes.getOrElse(key) { "-" }
            Int::class.java -> thisRef.attributes.getOrElse(key) { 0 }
            else -> throw IllegalArgumentException("Wrong type")
        } as T
    }
}

inline fun <reified T> TestDelegation.attribute(
    key: String,
) = AttributeDelegation(
    key = key,
    type = T::class.java,
)
