package corporation

import oop.ApplianceCard
import oop.CodeType
import oop.FoodCard
import oop.ProductCard
import oop.ProductType
import oop.ShoeCard
import java.io.File

class Accountant(name: String, age: Int): Worker(name, age) {
    val file = File("product_card.txt")

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
                CodeType.EXIT -> break
                CodeType.REGISTER -> registerProduct()
                CodeType.SHOW_ALL_ITEMS -> showAllItems()
                CodeType.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun loadAllItems(): MutableList<ProductCard> {
        val lines = file.readLines()
        val cards = mutableListOf<ProductCard>()

        if (lines.isEmpty()) return cards

        for(line in lines) {
            val (name, brand, price, trademark, type) = line.split("%")
            val productType = ProductType.valueOf(type)

            val product = when(productType) {
                ProductType.FOOD -> FoodCard(name, brand, price.toInt(), trademark.toInt())
                ProductType.APPLIANCE -> ApplianceCard(name, brand, price.toInt(), trademark.toInt())
                ProductType.SHOE -> ShoeCard(name, brand, price.toInt(), trademark.toInt())
            }

            cards.add(product)
        }

        return cards
    }

    fun showAllItems() {
        val cards = loadAllItems()

        for (card in cards) {
            card.printInfo()
        }
    }

    fun getNameBrandPrice(): List<String> {
        print("enter the product name:")
        val productName = readln()
        print("enter the product brand:")
        val productBrand = readln()
        print("enter the product price:")
        val productPrice = readln()

        return listOf(productName, productBrand, productPrice)
    }

    fun registerProduct() {
        val productTypes = ProductType.entries
        print("enter the product type.")
        for ((ind, type) in productTypes.withIndex()) {
            print("$ind - ${type.title}")
        }
        val productInd = readln().toInt()
        val productType = productTypes[productInd]

        val (name, brand, price) = getNameBrandPrice()
        val card = when (productType) {
            ProductType.FOOD -> {
                print("enter the product caloric: ")
                val trademark = readln().toInt()
                FoodCard(name, brand, price.toInt(), trademark)
            }
            ProductType.APPLIANCE -> {
                print("enter the product wattage: ")
                val trademark = readln().toInt()
                ApplianceCard(name, brand, price.toInt(), trademark)
            }
            ProductType.SHOE -> {
                print("enter the product size: ")
                val trademark = readln().toInt()
                ShoeCard(name, brand, price.toInt(), trademark)
            }
        }

        saveProductCardToFile(card)
    }

    fun saveProductCardToFile(card: ProductCard) {
        file.appendText("${card.name}%${card.brand}%${card.price}%")

        when (card) {
            is FoodCard -> file.appendText("${card.caloric}%")
            is ApplianceCard -> file.appendText("${card.wattage}%")
            is ShoeCard -> file.appendText("${card.size}%")
        }
        file.appendText("${card.type}\n")
    }

    fun removeProductCard() {
        val cards = loadAllItems()
        println("enter card name for removing: ")
        val name = readln()

        for ((ind, card) in cards.withIndex()) {
            if (card.name == name) {
                cards.removeAt(ind)
                break
            }
        }
        file.writeText("")

        for (card in cards) {
            saveProductCardToFile(card)
        }
    }
}