package org.rescueme.es.shelter.application.view.create

import org.axonframework.eventhandling.EventHandler
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.create.ShelterCreatedEvent
import org.rescueme.es.shelter.domain.view.create.ShelterViewCreator
import org.springframework.stereotype.Component

@Component
class CreateShelterViewOnShelterCreatedEvent(private val creator: ShelterViewCreator) {

    @EventHandler
    fun on(event: ShelterCreatedEvent) {
        creator(
            shelterId = ShelterId.fromString(event.aggregateId),
            details = event.details,
            location = event.location
        )
    }
}