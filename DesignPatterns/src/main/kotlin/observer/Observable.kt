package observer

interface Observable<T> {
    val currentCollection: T

//    fun getObservers(): List<Observer<T>>
    val observers: List<Observer<T>>

    fun registerObserver(observer: Observer<T>)
    fun unregisterObserver(observer: Observer<T>)

    fun notifyObservers() {
        for (observer in observers) {
            observer.onChanged(currentCollection)
        }
    }
}