package org.rescueme.es.shelter.domain

interface ShelterRepository {
    fun new(shelterId: ShelterId)
}