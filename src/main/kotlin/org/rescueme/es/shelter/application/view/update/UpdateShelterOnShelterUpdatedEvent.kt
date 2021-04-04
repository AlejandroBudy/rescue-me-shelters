package org.rescueme.es.shelter.application.view.update

import org.axonframework.eventhandling.EventHandler
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.update.ShelterUpdatedEvent
import org.rescueme.es.shelter.domain.view.update.ShelterViewUpdater
import org.springframework.stereotype.Component

@Component
class UpdateShelterOnShelterUpdatedEvent(private val updater: ShelterViewUpdater) {

    @EventHandler
    fun on(event: ShelterUpdatedEvent) {
        updater(
            shelterId = ShelterId.fromString(event.aggregateId),
            shelterDetails = event.details
        )
    }
}