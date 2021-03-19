package org.rescueme.es.shelter.utils

import org.rescueme.es.shelter.adapter.create.CreateShelterRequest
import org.rescueme.es.shelter.adapter.find.ShelterRestResponse
import org.rescueme.es.shelter.application.create.CreateShelterCommand
import org.rescueme.es.shelter.application.view.ShelterResponse
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.create.ShelterCreatedEvent
import org.rescueme.es.shelter.domain.view.ShelterView
import java.time.ZonedDateTime


const val shelterId: String = "15708b33-e1ad-4a4b-bb0a-af3c1307ab01"

val shelterIdVO = ShelterId.fromString(shelterId)
val now = ZonedDateTime.now()

fun createShelterRequest() =
    CreateShelterRequest(shelterId)

fun createShelterCommand() =
    CreateShelterCommand(shelterId)

fun createShelterView() =
    ShelterView(shelterIdVO)

fun createShelterResponse() =
    ShelterResponse(shelterId)

fun createShelterRestResponse() =
    ShelterRestResponse(shelterId)

fun createShelterCreatedEvent() =
    ShelterCreatedEvent(aggregateId = shelterId, occurredOn = now)