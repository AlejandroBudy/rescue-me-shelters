package org.rescueme.es.shelter.utils

import org.rescueme.es.shelter.adapter.create.CreateShelterRequest
import org.rescueme.es.shelter.adapter.find.ShelterDetailsRestResponse
import org.rescueme.es.shelter.adapter.find.ShelterLocationRestResponse
import org.rescueme.es.shelter.adapter.find.ShelterRestResponse
import org.rescueme.es.shelter.application.create.CreateShelterCommand
import org.rescueme.es.shelter.application.view.ShelterDetailsResponse
import org.rescueme.es.shelter.application.view.ShelterLocationResponse
import org.rescueme.es.shelter.application.view.ShelterResponse
import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.ShelterLocation
import org.rescueme.es.shelter.domain.create.ShelterCreatedEvent
import org.rescueme.es.shelter.domain.view.ShelterView
import java.time.ZonedDateTime


const val shelterId: String = "15708b33-e1ad-4a4b-bb0a-af3c1307ab01"
const val name = "Shelter-test"
const val location = "Shelter-test-address"

val shelterIdVO = ShelterId.fromString(shelterId)
val shelterDetails = ShelterDetails.create(name)
val shelterLocation = ShelterLocation.createLocation(location)
val now = ZonedDateTime.now()

fun createShelterRequest() =
    CreateShelterRequest(name, location)

fun createShelterCommand() =
    CreateShelterCommand(shelterId, name, location)

fun createShelterView() =
    ShelterView(shelterIdVO, shelterDetails, shelterLocation)

fun createShelterResponse() =
    ShelterResponse(
        shelterId,
        createShelterDetailsResponse(),
        createShelterLocationResponse()
    )

fun createShelterDetailsResponse() =
    ShelterDetailsResponse(name)

fun createShelterLocationResponse() =
    ShelterLocationResponse(location)

fun createShelterRestResponse() =
    ShelterRestResponse(
        shelterId,
        createShelterDetailsRestResponse(),
        createShelterLocationRestResponse()
    )

fun createShelterDetailsRestResponse() =
    ShelterDetailsRestResponse(name)

fun createShelterLocationRestResponse() =
    ShelterLocationRestResponse(location)

fun createShelterCreatedEvent() =
    ShelterCreatedEvent(
        aggregateId = shelterId,
        occurredOn = now,
        details = shelterDetails,
        location = shelterLocation
    )