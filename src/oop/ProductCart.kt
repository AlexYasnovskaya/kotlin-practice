package oop

class ProductCart {
    var name: String = ""
    var brand: String = ""
    var size: Float = 0.0F
    var price: Int = 0

    fun init(name: String, brand: String, size: Float, price: Int) {
        this.name = name
        this.brand = brand
        this.size = size
        this.price = price
    }

    fun printInfo() {
        println("name: $name, brand: $brand, size: $size, price: $price")
    }
}