package oop

data class ShoeCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val size: Int
): ProductCard(name, brand, price, ProductType.SHOE)