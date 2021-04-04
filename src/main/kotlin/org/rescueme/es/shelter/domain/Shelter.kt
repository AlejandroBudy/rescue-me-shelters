package org.rescueme.es.shelter.domain

import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.axonframework.eventhandling.EventHandler
import org.axonframework.spring.stereotype.Aggregate
import org.rescueme.es.shelter.domain.create.ShelterCreatedEvent
import org.rescueme.es.shelter.domain.update.ShelterUpdatedEvent
import java.time.ZonedDateTime

@Aggregate
class Shelter {

    @AggregateIdentifier
    private lateinit var shelterId: ShelterId
    private lateinit var details: ShelterDetails
    private lateinit var location: ShelterLocation

    @EventHandler
    fun on(event: ShelterCreatedEvent) {
        shelterId = ShelterId.fromString(event.aggregateId)
        details = event.details
        location = event.location
    }

    @EventHandler
    fun on(event: ShelterUpdatedEvent) {
        this.details.update(event.details)
    }

    @EventHandler
    fun updateDetails(details: ShelterDetails) {
        apply(
            ShelterUpdatedEvent(
                shelterId.asString(),
                ZonedDateTime.now(),
                details
            )
        )
    }

    companion object {
        fun create(
            shelterId: ShelterId,
            shelterDetails: ShelterDetails,
            shelterLocation: ShelterLocation
        ) {
            apply(
                ShelterCreatedEvent(
                    aggregateId = shelterId.asString(),
                    occurredOn = ZonedDateTime.now(),
                    details = shelterDetails,
                    location = shelterLocation
                )
            )
        }
    }

}