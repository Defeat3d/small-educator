package nl.smallo.smalleducator.student.ui

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.property.*
import java.util.concurrent.Callable
import kotlin.reflect.KProperty

interface DelegateProperties {

    operator fun <T> Property<T>.setValue(thisRef: Any, property: KProperty<*>, value: T) = this@DelegateProperties.setValue(this, value)
    operator fun <T> Property<T>.getValue(thisRef: Any, property: KProperty<*>): T = this@DelegateProperties.getValue(this)
    operator fun <T> ReadOnlyProperty<T>.getValue(thisRef: Any, property: KProperty<*>): T = this@DelegateProperties.getValue(this)

    operator fun IntegerProperty.setValue(thisRef: Any, property: KProperty<*>, value: Int) = this@DelegateProperties.setValue(this, value)
    operator fun IntegerProperty.getValue(thisRef: Any, property: KProperty<*>): Int = this@DelegateProperties.getValue(this) as Int
    operator fun ReadOnlyIntegerProperty.getValue(thisRef: Any, property: KProperty<*>): Int = this@DelegateProperties.getValue(this) as Int

    operator fun LongProperty.setValue(thisRef: Any, property: KProperty<*>, value: Long) = this@DelegateProperties.setValue(this, value)
    operator fun LongProperty.getValue(thisRef: Any, property: KProperty<*>): Long = this@DelegateProperties.getValue(this) as Long
    operator fun ReadOnlyLongProperty.getValue(thisRef: Any, property: KProperty<*>): Long = this@DelegateProperties.getValue(this) as Long

    operator fun FloatProperty.setValue(thisRef: Any, property: KProperty<*>, value: Float) = this@DelegateProperties.setValue(this, value)
    operator fun FloatProperty.getValue(thisRef: Any, property: KProperty<*>): Float = this@DelegateProperties.getValue(this) as Float
    operator fun ReadOnlyFloatProperty.getValue(thisRef: Any, property: KProperty<*>): Float = this@DelegateProperties.getValue(this) as Float

    operator fun DoubleProperty.setValue(thisRef: Any, property: KProperty<*>, value: Double) = this@DelegateProperties.setValue(this, value)
    operator fun DoubleProperty.getValue(thisRef: Any, property: KProperty<*>): Double = this@DelegateProperties.getValue(this) as Double
    operator fun ReadOnlyDoubleProperty.getValue(thisRef: Any, property: KProperty<*>): Double = this@DelegateProperties.getValue(this) as Double

    fun <T> setValue(property: Property<T>, value: T) {
        property.value = value
    }

    fun <T> getValue(property: ReadOnlyProperty<T>): T {
        return property.value
    }

}

inline fun <reified T> BooleanBinding.either(whenTrue: T, whenFalse: T) = Bindings.createObjectBinding(Callable { if (get()) whenTrue else whenFalse }, this)
