package observer

interface Observer<T> {
    fun onChanged(collection: T)
}