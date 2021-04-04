package org.rescueme.es.shelter.domain

interface ShelterRepository {
    fun new(
        shelterId: ShelterId, shelterDetails: ShelterDetails,
        shelterLocation: ShelterLocation
    )

    fun load(shelterId: ShelterId): Shelter?
}