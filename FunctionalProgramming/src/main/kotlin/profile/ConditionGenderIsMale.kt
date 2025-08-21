package profile

class ConditionGenderIsMale: Condition {
    override fun isSuitable(person: Person): Boolean = person.gender == Gender.MALE
}