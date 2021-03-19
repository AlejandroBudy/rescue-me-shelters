package org.rescueme.es.shelter.domain.view.find

import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.springframework.stereotype.Service

@Service
class SheltersFinder(private val shelterViewRepository: ShelterViewRepository) {

    operator fun invoke() = shelterViewRepository.findAll()
}