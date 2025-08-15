package corporation

import oop.ApplianceCard
import oop.FoodCard
import oop.ProductCard
import oop.ProductType
import oop.ShoeCard
import java.io.File

class ProductCardRepository {
    private val file = File("product_card.txt")

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

    fun registerNewProduct(card: ProductCard) {
        saveProductCardToFile(card)
    }

    private fun saveProductCardToFile(card: ProductCard) {
        file.appendText("${card.name}%${card.brand}%${card.price}%")

        when (card) {
            is FoodCard -> file.appendText("${card.caloric}%")
            is ApplianceCard -> file.appendText("${card.wattage}%")
            is ShoeCard -> file.appendText("${card.size}%")
        }
        file.appendText("${card.type}\n")
    }

    fun removeProductCard(name: String) {
        val cards = loadAllItems()
        file.writeText("")

        for ((ind, card) in cards.withIndex()) {
            if (card.name != name) {
                saveProductCardToFile(card)
            }
        }
    }
}