package corporation

import oop.ApplianceCard
import oop.FoodCard
import oop.ProductCard
import oop.ProductType
import oop.ShoeCard
import java.io.File

class ProductCardRepository {
    private val file = File("product_card.txt")
    val productCards = loadAllItems()

    private fun loadAllItems(): MutableList<ProductCard> {
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
        productCards.add(card)
    }

    fun saveChanges() {
        var content = StringBuilder()
        for (card in productCards) {
            content.append("${card.name}%${card.brand}%${card.price}%")

            when (card) {
                is FoodCard -> content.append("${card.caloric}%")
                is ApplianceCard -> content.append("${card.wattage}%")
                is ShoeCard -> content.append("${card.size}%")
            }
            content.append("${card.type}\n")
        }

        file.appendText(content.toString())
    }

    fun removeProductCard(name: String) {
        for (card in productCards) {
            if (card.name == name) {
                productCards.remove(card)
                break
            }
        }
    }
}