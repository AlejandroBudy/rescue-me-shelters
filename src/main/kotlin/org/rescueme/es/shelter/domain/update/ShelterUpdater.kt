package org.rescueme.es.shelter.domain.update

import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.ShelterNotFoundException
import org.rescueme.es.shelter.domain.ShelterRepository
import org.springframework.stereotype.Service

@Service
class ShelterUpdater(private val shelterRepository: ShelterRepository) {

    operator fun invoke(shelterId: ShelterId, details: ShelterDetails) {
        shelterRepository.load(shelterId)
            .also { it ?: throw ShelterNotFoundException("Shelter $shelterId not found") }!!
            .updateDetails(details)

    }
}