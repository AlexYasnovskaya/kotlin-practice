package oop

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name, brand, price, ProductType.FOOD) {
    override fun printInfo() {
        super.printInfo()
        print(", caloric: $caloric")
    }
}