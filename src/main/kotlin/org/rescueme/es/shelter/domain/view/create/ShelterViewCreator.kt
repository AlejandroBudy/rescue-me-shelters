package org.rescueme.es.shelter.domain.view.create

import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.ShelterLocation
import org.rescueme.es.shelter.domain.view.ShelterView
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.springframework.stereotype.Service

@Service
class ShelterViewCreator(private val shelterViewRepository: ShelterViewRepository) {

    operator fun invoke(shelterId: ShelterId, details: ShelterDetails, location: ShelterLocation) {
        ShelterView(shelterId, details, location)
            .let { shelterViewRepository.create(it) }
    }
}