package org.rescueme.es.shelter.domain.view

interface ShelterViewRepository {

    fun create(shelterView: ShelterView)
    fun findAll(): List<ShelterView>
}