package oop

class Person(
    val name: String,
    val height: Int,
    val weight: Int,
    val lastName: String,
) {
    var age: Int = 0
        set(value) {
            if (value > field) {
                field = value
            } else {
                println("the new age must be than the old one")
            }
        }
        get() {
            println("its indecent to ask a person his age")
            return age
        }

    val fullName: String
        get() = "$lastName $name"

    fun sayHello() {
        println("Hello!")
    }

    fun run() {
        repeat(10) {
            print("Бегу")
        }
    }

    fun copy(name: String = this.name, lastName: String = this.lastName, weight: Int = this.weight, height: Int = this.height): Person {
        return Person(name, height, weight, lastName)
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + fullName.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (lastName != other.lastName) return false

        return true
    }

    override fun toString(): String {
        return "Person(name='$name', height=$height, weight=$weight, lastName='$lastName')"
    }
}