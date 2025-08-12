package corporation

import oop.ApplianceCard
import oop.CodeType
import oop.FoodCard
import oop.ProductCard
import oop.ProductType
import oop.ShoeCard
import java.io.File

class Accountant(name: String, age: Int, id: Int): Worker(name, age, id, WorkerType.ACCOUNTANT) {
    val file = File("product_card.txt")
    val fileEmployees = File("employees.txt")

    override fun work() {
        while (true) {
            val codeTypes = CodeType.entries
            println("\nenter the operation code.")
            for ((ind, type) in codeTypes.withIndex()) {
                println("$ind - ${type.title};")
            }
            val code = readln().toInt()
            val humanCode = codeTypes[code]
            when (humanCode) {
                CodeType.EXIT -> break
                CodeType.REGISTER -> registerProduct()
                CodeType.SHOW_ALL_ITEMS -> showAllItems()
                CodeType.REMOVE_PRODUCT_CARD -> removeProductCard()
                CodeType.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                CodeType.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                CodeType.SHOW_ALL_EMPLOYEES -> showAllEmployees()
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

    fun registerNewEmployee() {
        val workerTypes = WorkerType.entries
        print("enter the worker type:")
        for ((ind, workerType) in workerTypes.withIndex()) {
            print("$ind - ${workerType.title}; ")
        }
        val typeIndex = readln().toInt()
        val humanType = workerTypes[typeIndex]

        print("enter id: ")
        val id = readln().toInt()
        print("enter name: ")
        val name = readln()
        print("enter age: ")
        val age = readln().toInt()

        val employee = when(humanType) {
            WorkerType.ACCOUNTANT -> Accountant(name, age, id)
            WorkerType.DIRECTOR -> Director(name, age, id)
            WorkerType.CONSULTANT -> Consultant(name, age, id)
            WorkerType.ASSISTANT -> Assistant(name, age, id)
        }

        saveAnEmployeeToFile(employee)
    }

    fun loadAllEmployees(): MutableList<Worker> {
        val lines = file.readLines()
        val employees = mutableListOf<Worker>()

        if (lines.isEmpty()) return employees

        for(line in lines) {
            val (id, name, age, type) = line.split("%")
            val workerType = WorkerType.valueOf(type)

            val employee = when(workerType) {
                WorkerType.ACCOUNTANT -> Accountant(name, age.toInt(), id.toInt())
                WorkerType.DIRECTOR -> Director(name, age.toInt(), id.toInt())
                WorkerType.CONSULTANT -> Consultant(name, age.toInt(), id.toInt())
                WorkerType.ASSISTANT -> Assistant(name, age.toInt(), id.toInt())
            }

            employees.add(employee)
        }

        return employees
    }

    fun saveAnEmployeeToFile(employee: Worker) {
        file.appendText("${employee.id}%${employee.name}%${employee.age}%${employee.workerType}\n")
    }

    fun fireAnEmployee() {
        print("enter id to fire: ")
        val id = readln().toInt()
        val employees = loadAllEmployees()

        for ((ind, employee) in employees.withIndex()) {
            if (employee.id == id) {
                employees.removeAt(ind)
                break
            }
        }
        file.writeText("")

        for (employee in employees) {
            saveAnEmployeeToFile(employee)
        }
    }

    fun showAllEmployees() {
        val employees = loadAllEmployees()

        for (employee in employees) {
            employee.printInfo()
        }
    }
}