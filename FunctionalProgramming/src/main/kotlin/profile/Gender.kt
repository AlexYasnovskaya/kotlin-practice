package profile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Gender(val title: String) {
    @SerialName("Male") MALE("male"),
    @SerialName("Female") FEMALE("female")
}