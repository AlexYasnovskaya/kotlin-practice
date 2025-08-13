package oop

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Int
): ProductCard(name, brand, price, ProductType.SHOE) {
    override fun toString(): String {
        return "name: $name, brand: $brand, price: $price, size: $size, type: $type"
    }
}