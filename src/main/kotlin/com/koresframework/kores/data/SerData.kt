package com.koresframework.kores.data

import com.koresframework.kores.serialization.KeySerializer
import com.koresframework.kores.serialization.KoresDataSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Serializable(with = KoresDataSerializer::class)
class KoresData(dataMap: Map<SerKey, SerData> = emptyMap()) {
    private val dataMap = ConcurrentHashMap(dataMap)

    val dataMapView = Collections.unmodifiableMap(this.dataMap)

    fun <T: Any> offer(key: Key<T>, value: T) {
        this.dataMap[SerKey(key.name)] = SerData(value)
    }

    fun <T: Any> query(key: Key<T>): T? =
        this.dataMap[SerKey(key.name)]?.let { it.value as T }

    fun from(other: KoresData) {
        this.dataMap.putAll(other.dataMap)
    }
}

@Serializable
data class Key<T: Any>(val name: String)

@Serializable(with = KeySerializer::class)
data class SerKey(val name: String)

@Serializable
data class SerData(@Contextual val value: Any)