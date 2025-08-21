package profile

class ConditionNameStartWithA: Condition {
    override fun isSuitable(person: Person): Boolean = person.firstName.startsWith("A")
}