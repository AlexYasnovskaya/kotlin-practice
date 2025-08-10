package corporation

import oop.ApplianceCard
import oop.CodeType
import oop.FoodCard
import oop.ProductCard
import oop.ProductType
import oop.ShoeCard

class Accountant(name: String, age: Int): Worker(name, age) {
    val items = mutableListOf<ProductCard>()

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
        val productTypes = ProductType.entries
        print("enter the product type.")
        for ((ind, type) in productTypes.withIndex()) {
            print("$ind - ${type.title}")
        }
        val productInd = readln().toInt()
        val productType = productTypes[productInd]

        val product: ProductCard = when (productType) {
            ProductType.FOOD -> createFoodCard()
            ProductType.APPLIANCE -> createApplianceCard()
            ProductType.SHOE -> createShoeCard()
        }

        items.add(product)
    }
    override fun work() {
        while (true) {
            val codeTypes = CodeType.entries
            print("\nenter the operation code. 0 - ${codeTypes[0]}, 1 - ${codeTypes[1]}, 2 - ${codeTypes[2]}: ")
            val code = readln().toInt()
            val humanCode = codeTypes[code]
            when (humanCode) {
                CodeType.REGISTER -> registerProduct()
                CodeType.EXIT -> break
                CodeType.SHOW_ALL_ITEMS -> showAllItems()
            }
        }
    }

    fun showAllItems() {
        for(item in items) {
            item.printInfo()
        }
    }
}