package org.rescueme.es.shelter.domain.create

import org.rescueme.es.shared.domainevent.DomainEvent
import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterLocation
import java.time.ZonedDateTime

data class ShelterCreatedEvent(
    val aggregateId: String,
    val occurredOn: ZonedDateTime,
    val details: ShelterDetails,
    val location: ShelterLocation
) : DomainEvent {
    override fun aggregateId() = aggregateId

    override fun occurredOn() = occurredOn
}