package org.rescueme.es.shelter.domain

import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.axonframework.eventhandling.EventHandler
import org.axonframework.spring.stereotype.Aggregate
import org.rescueme.es.shelter.domain.create.ShelterCreatedEvent
import java.time.ZonedDateTime

@Aggregate
class Shelter {

    @AggregateIdentifier
    private lateinit var shelterId: ShelterId

    @EventHandler
    fun on(event: ShelterCreatedEvent) {
        shelterId = ShelterId.fromString(event.aggregateId)
    }

    companion object {
        fun create(shelterId: ShelterId) =
            apply(ShelterCreatedEvent(shelterId.asString(), ZonedDateTime.now()))
    }

}