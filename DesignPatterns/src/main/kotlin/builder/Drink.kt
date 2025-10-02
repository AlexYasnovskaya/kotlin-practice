package builder

import java.text.Bidi

data class Drink(
    val type: String,
    val additives: List<String>,
    val diningOption: String,
    val temperature: String
) {
    class Builder {
        private var type: String = "Coffee"
        private var additives: List<String> = listOf()
        private var diningOption: String = "to go"
        private var temperature: String = "hot"

        fun type(value: String): Builder {
            this.type = value
            return this
        }
        fun additives(value: List<String>): Builder {
            this.additives = value
            return this
        }
        fun diningOption(value: String): Builder {
            this.diningOption = value
            return this
        }
        fun temperature(value: String): Builder {
            this.temperature = value
            return this
        }

        fun build(): Drink {
            return Drink(type, additives, diningOption, temperature)
        }
    }
}
