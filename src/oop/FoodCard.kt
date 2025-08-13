package oop

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name, brand, price, ProductType.FOOD) {
    override fun toString(): String {
        return "name: $name, brand: $brand, price: $price, caloric: $caloric, type: $type"
    }
}