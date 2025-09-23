package observer

fun interface Observer<T> {
    fun onChanged(collection: T)
}