package org.rescueme.es.shelter.domain.view.update

import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.springframework.stereotype.Component

@Component
class ShelterViewUpdater(private val repository: ShelterViewRepository) {

    operator fun invoke(shelterId: ShelterId, shelterDetails: ShelterDetails){
        repository.update(shelterId, shelterDetails)
    }
}