package profile

import products.ProductRepository

fun main() {
    val profiles = ProfilesRepository.profiles

    for (profile in profiles) {
        println(profile)
    }
}

