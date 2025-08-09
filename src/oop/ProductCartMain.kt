package oop

fun main() {
    println("name, brand, size, price")
    val ( name, brand, size, price ) = readln().split(" ")

    val productCart: ProductCart = ProductCart()
    productCart.init(name, brand, size.toFloat(), price.toInt())
    productCart.printInfo()
}