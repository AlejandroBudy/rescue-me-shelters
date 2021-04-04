package org.rescueme.es.shelter.domain

import org.rescueme.es.shared.valueobject.ValueObject
import javax.persistence.Column
import javax.persistence.Embedded

@ValueObject
data class ShelterLocation(@Embedded val city: City) {

    companion object {
        fun createLocation(name: String, postalCode: String? = null) =
            ShelterLocation(
                city = City(name = name, postalCode = postalCode)
            )
    }
}

@ValueObject
data class City(
    @Column(name = "city_name") val name: String,
    val postalCode: String?
)