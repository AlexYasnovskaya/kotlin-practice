package dictionary

import kotlinx.serialization.json.Json
import java.io.File
import java.util.Dictionary

fun main() {
    val file = File("dictionary.json")
    val content = file.readText().trim()
    val dictionary = Json.decodeFromString<List<Entry>>(content)
    showDescription(dictionary)
}

fun showDescription(dictionary: List<Entry>) {
    while (true) {
        println("enter value or 0")
        val value = readln().lowercase()
        if (value == "0") break
        dictionary.find { it.value == value }?.let { println(it.description) } ?: println("not found")
    }
}