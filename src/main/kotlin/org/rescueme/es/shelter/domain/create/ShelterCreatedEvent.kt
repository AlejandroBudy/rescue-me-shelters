package org.rescueme.es.shelter.domain.create

import org.rescueme.es.shared.domainevent.DomainEvent
import java.time.ZonedDateTime

data class ShelterCreatedEvent(
    val aggregateId: String,
    val occurredOn: ZonedDateTime
) : DomainEvent {
    override fun aggregateId() = aggregateId

    override fun occurredOn() = occurredOn
}