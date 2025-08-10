package oop

open class ProductCard {
    val name: String
    val brand: String
    val price: Int

    constructor(name: String, brand: String, price: Int) {
        this.name = name
        this.brand = brand
        this.price = price
    }

    open fun printInfo() {
        print("name: $name, brand: $brand, price: $price")
    }
}