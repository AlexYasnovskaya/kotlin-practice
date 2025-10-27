package collections

interface MyMap<K, V> {
    val size: Int
    operator fun get(key: K): V?
    fun containsKey(key: K): Boolean
    fun containValue(value: V): Boolean
    val keys: MySet<K>
    val values: MyCollection<V>
}