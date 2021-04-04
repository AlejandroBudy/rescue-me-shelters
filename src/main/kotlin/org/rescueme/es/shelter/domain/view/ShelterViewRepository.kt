package org.rescueme.es.shelter.domain.view

import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId

interface ShelterViewRepository {

    fun create(shelterView: ShelterView)
    fun findAll(): List<ShelterView>
    fun update(shelterId: ShelterId, shelterDetails: ShelterDetails)
}