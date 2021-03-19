package org.rescueme.es.shelter.domain.view.create

import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.view.ShelterView
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.springframework.stereotype.Service

@Service
class ShelterViewCreator(private val shelterViewRepository: ShelterViewRepository) {

    operator fun invoke(shelterId: ShelterId) {
        ShelterView(shelterId).let { shelterViewRepository.create(it) }
    }
}