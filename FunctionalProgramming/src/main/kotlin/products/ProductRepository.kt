package products

import kotlinx.serialization.json.Json
import profile.Person
import java.io.File

object ProductRepository {
    private val file = File("products.json")
    private val _products = loadProducts()
    val products
        get() = _products.toList()

    private fun loadProducts(): List<Products> {
        val content = file.readText().trim()
        return Json.decodeFromString(content)
    }
}