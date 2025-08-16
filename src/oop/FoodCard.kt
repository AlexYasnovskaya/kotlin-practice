package oop

data class FoodCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val caloric: Int
): ProductCard(name, brand, price, ProductType.FOOD)