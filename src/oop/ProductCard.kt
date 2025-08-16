package oop

abstract class ProductCard(
    open val name: String,
    open val brand: String,
    open val price: Int,
    val type: ProductType
) {
    fun printInfo() {
        println(this)
    }
}