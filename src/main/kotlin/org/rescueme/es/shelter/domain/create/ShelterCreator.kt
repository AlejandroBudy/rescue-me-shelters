package org.rescueme.es.shelter.domain.create

import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.ShelterRepository
import org.springframework.stereotype.Service

@Service
class ShelterCreator(private val shelterRepository: ShelterRepository) {

    operator fun invoke(shelterId: ShelterId) =
        shelterRepository.new(shelterId)

}