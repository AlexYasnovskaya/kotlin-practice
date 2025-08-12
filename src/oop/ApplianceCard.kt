package oop

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int,
): ProductCard(name, brand, price, ProductType.APPLIANCE) {
    override fun printInfo() {
        print("name: $name, brand: $brand, price: $price, wattage: $wattage, type: $type")
    }
}