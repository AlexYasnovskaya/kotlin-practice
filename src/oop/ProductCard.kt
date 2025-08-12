package oop

abstract class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val type: ProductType
) {
    abstract fun printInfo()
}