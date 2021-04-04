package org.rescueme.es.shelter.domain.update

import org.rescueme.es.shared.domainevent.DomainEvent
import org.rescueme.es.shelter.domain.ShelterDetails
import java.time.ZonedDateTime

data class ShelterUpdatedEvent(
    val aggregateId: String,
    val occurredOn: ZonedDateTime,
    val details: ShelterDetails
) : DomainEvent {
    override fun aggregateId() =
        aggregateId

    override fun occurredOn() =
        occurredOn

}