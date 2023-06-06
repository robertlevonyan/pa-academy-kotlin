package classes.delegation

import classes.PropertyDelegation
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MutableDelegation : ReadWriteProperty<
        PropertyDelegation, String> {
    override fun getValue(
        thisRef: PropertyDelegation,
        property: KProperty<*>,
        ): String {
        return thisRef.toString()
    }

    override fun setValue(
        thisRef: PropertyDelegation,
        property: KProperty<*>,
        value: String,
    ) {

    }
}

fun PropertyDelegation.mutable() = MutableDelegation()