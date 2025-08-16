package corporation

import oop.ApplianceCard
import oop.CodeType
import oop.FoodCard
import oop.ProductType
import oop.ShoeCard

class Accountant(
    name: String,
    age: Int,
    id: Int,
    salary: Int
): Worker(
    name,
    age,
    id,
    salary,
    WorkerType.ACCOUNTANT
), Cleaner, Supplier {
    private val workerRepository = WorkerRepository
    private val productCardRepository = ProductCardRepository

    override fun copy(salary: Int, age: Int): Accountant {
        return Accountant(this.name, age, this.id, salary)
    }

    override fun clean() {
        print("my position is ${super.workerType.title}. ")
        super.clean()
    }

    override fun buyingThings() {
        print("my position is ${super.workerType.title}. ")
        super.buyingThings()
    }

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
                CodeType.EXIT -> {
                    workerRepository.saveChanges()
                    productCardRepository.saveChanges()
                    break
                }
                CodeType.REGISTER -> registerProduct()
                CodeType.SHOW_ALL_ITEMS -> showAllItems()
                CodeType.REMOVE_PRODUCT_CARD -> removeProductCard()
                CodeType.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                CodeType.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                CodeType.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                CodeType.CHANGE_SALARY -> changeSalary()
                CodeType.CHANGE_AGE -> changeAge()
            }
        }
    }

    private fun showAllItems() {
        val cards = productCardRepository.productCards

        for (card in cards) {
            card.printInfo()
        }
    }

    private fun getNameBrandPrice(): List<String> {
        print("enter the product name:")
        val productName = readln()
        print("enter the product brand:")
        val productBrand = readln()
        print("enter the product price:")
        val productPrice = readln()

        return listOf(productName, productBrand, productPrice)
    }

    private fun registerProduct() {
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

            productCardRepository.registerNewProduct(card)
    }

    private fun removeProductCard() {
        println("enter card name for removing: ")
        val name = readln()
        productCardRepository.removeProductCard(name)
    }

    private fun registerNewEmployee() {
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
        print("enter salary")
        val salary = readln().toInt()

        val employee = when (humanType) {
            WorkerType.ACCOUNTANT -> Accountant(name, age, id, salary)
            WorkerType.DIRECTOR -> Director(name, age, id, salary)
            WorkerType.CONSULTANT -> Consultant(name, age, id, salary)
            WorkerType.ASSISTANT -> Assistant(name, age, id, salary)
        }

        workerRepository.registerNewEmployee(employee)
    }

    private fun fireAnEmployee() {
        print("enter id to fire: ")
        val id = readln().toInt()
        workerRepository.fireAnEmployee(id)
    }


    private fun showAllEmployees() {
        val employees = workerRepository.employees

        for (employee in employees) {
            employee.printInfo()
        }
    }

    private fun changeSalary() {
        print("enter id to change salary: ")
        val id = readln().toInt()
        print("enter new salary: ")
        val newSalary = readln().toInt()

        workerRepository.changeSalary(id, newSalary)
    }

    private fun changeAge() {
        print("enter id to change age: ")
        val id = readln().toInt()
        print("enter new age: ")
        val newAge = readln().toInt()

        workerRepository.changeAge(id, newAge)
    }
}