package classes.delegation

import classes.PropertyDelegation
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ImmutableDelegation : ReadOnlyProperty<
        PropertyDelegation, String> {
    override fun getValue(
        thisRef: PropertyDelegation,
        property: KProperty<*>,
        ): String {
        return thisRef.toString()
    }
}

fun PropertyDelegation.immutable() = ImmutableDelegation()