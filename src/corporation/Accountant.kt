package corporation

import oop.ApplianceCard
import oop.FoodCard
import oop.ProductCard
import oop.ShoeCard
import kotlin.system.exitProcess

class Accountant(name: String, age: Int): Worker(name, age) {
    fun getNameBrandPrice(): List<String> {
        print("enter the product name:")
        val productName = readln()
        print("enter the product brand:")
        val productBrand = readln()
        print("enter the product price:")
        val productPrice = readln()

        return listOf(productName, productBrand, productPrice)
    }

    fun createFoodCard(): ProductCard {
        val (name, brand, price) = getNameBrandPrice()
        print("enter the product caloric: ")
        val individualTrademark = readln().toInt()
        return FoodCard(name, brand, price.toInt(), individualTrademark)
    }

    fun createApplianceCard(): ProductCard {
        val (name, brand, price) = getNameBrandPrice()
        print("enter the product wattage: ")
        val individualTrademark = readln().toInt()
        return ApplianceCard(name, brand, price.toInt(), individualTrademark)
    }

    fun createShoeCard(): ProductCard {
        val (name, brand, price) = getNameBrandPrice()
        print("enter the product wattage: ")
        val individualTrademark = readln().toInt()
        return ShoeCard(name, brand, price.toInt(), individualTrademark)
    }

    fun registerProduct() {
        print("enter the product type. 0 - food, 1 - appliance, 2 - shoe: ")
        val productType = readln().toInt()

        val product: ProductCard = when (productType) {
            0 -> createFoodCard()
            1 -> createApplianceCard()
            2 -> createShoeCard()
            else -> ProductCard("", "", 0)
        }
        product.printInfo()
    }
    override fun work() {
        while (true) {
            print("\nenter the operation code. 0 - exit, 1 - register new item: ")
            val code = readln().toInt()
            if (code == 0) break
            else registerProduct()
        }
    }
}