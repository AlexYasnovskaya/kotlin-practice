package oop

open class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val type: ProductType
) {
    open fun printInfo() {
        print("name: $name, brand: $brand, price: $price, type: $type")
    }
}