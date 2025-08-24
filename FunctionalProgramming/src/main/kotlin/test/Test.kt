package test

import kotlinx.serialization.json.Json
import java.io.File

var age: Int? = 20

fun main() {
//    val file = File("books.json")
//    writeToFile(file)
//    val items = readFromFile(file)
//
//    for (item in items) {
//        println(item)
//    }

//    val a = readln().toInt()
//    println(a.isPositive())

    age?.let {
        if (it >= 18) {
            "ure an adult"
        } else {
            "ull be an adult ${18 - it} years "
        }
    }.let(::println)
}

//fun isPositive(number: Int) = number > 0
//fun Int.isPositive(): Boolean = this > 0 // extension function

//fun readFromFile(file: File): List<Book> {
//    val content = file.readText().trim()
//    return Json.decodeFromString<List<Book>>(content)
//}
//
//fun writeToFile(file: File) {
//    val books = mutableListOf<Book>()
//
//    while (true) {
//        println("write title or 0 to exit: ")
//        val name = readln()
//
//        if (name == "0") break
//
//        println("enter author: ")
//        val author = readln()
//
//        println("enter year: ")
//        val year = readln().toInt()
//
//        val item = Book(name, author, year)
//        books.add(item)
//    }
//
//    val itemsAsString = Json.encodeToString(books)
//    file.writeText(itemsAsString)
//}