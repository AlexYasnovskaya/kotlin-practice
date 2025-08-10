package corporation

import oop.ApplianceCard
import oop.CodeType
import oop.FoodCard
import oop.ProductCard
import oop.ProductType
import oop.ShoeCard
import java.io.File

class Accountant(name: String, age: Int): Worker(name, age) {
    val items = mutableListOf<ProductCard>()
    val file = File("product_card.txt")

    fun getNameBrandPrice(): List<String> {
        print("enter the product name:")
        val productName = readln()
        file.appendText("$productName%")
        print("enter the product brand:")
        val productBrand = readln()
        file.appendText("$productBrand%")
        print("enter the product price:")
        val productPrice = readln()
        file.appendText("$productPrice%")

        return listOf(productName, productBrand, productPrice)
    }

    fun createFoodCard() {
        getNameBrandPrice()
        print("enter the product caloric: ")
        val individualTrademark = readln().toInt()
        file.appendText("$individualTrademark%")
    }

    fun createApplianceCard() {
        getNameBrandPrice()
        print("enter the product wattage: ")
        val individualTrademark = readln().toInt()
        file.appendText("$individualTrademark%")
    }

    fun createShoeCard() {
        getNameBrandPrice()
        print("enter the product wattage: ")
        val individualTrademark = readln().toInt()
        file.appendText("$individualTrademark%")
    }

    fun registerProduct() {
        val productTypes = ProductType.entries
        print("enter the product type.")
        for ((ind, type) in productTypes.withIndex()) {
            print("$ind - ${type.title}")
        }
        val productInd = readln().toInt()
        val productType = productTypes[productInd]

        when (productType) {
            ProductType.FOOD -> createFoodCard()
            ProductType.APPLIANCE -> createApplianceCard()
            ProductType.SHOE -> createShoeCard()
        }

        file.appendText("$productType\n")
    }
    override fun work() {
        while (true) {
            val codeTypes = CodeType.entries
            print("\nenter the operation code.")
            for ((ind, type) in codeTypes.withIndex()) {
                print("$ind - ${type.title}, ")
            }
            print(": ")
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
        val lines = file.readLines()

        for(line in lines) {
            val (name, brand, price, trademark, type) = line.split("%")
            val productType = ProductType.valueOf(type)

            val product = when(productType) {
                ProductType.FOOD -> FoodCard(name, brand, price.toInt(), trademark.toInt())
                ProductType.APPLIANCE -> ApplianceCard(name, brand, price.toInt(), trademark.toInt())
                ProductType.SHOE -> ShoeCard(name, brand, price.toInt(), trademark.toInt())
            }

            product.printInfo()
            items.add(product)
        }
    }
}