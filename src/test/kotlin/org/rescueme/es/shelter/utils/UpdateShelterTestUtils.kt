package org.rescueme.es.shelter.utils

import org.rescueme.es.shelter.adapter.update.UpdateShelterRequest
import org.rescueme.es.shelter.application.update.UpdateShelterCommand
import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.update.ShelterUpdatedEvent

const val shelterName = "test-shelter"

fun updateShelterRequest() =
    UpdateShelterRequest(shelterName)

fun updateShelterCommand() =
    UpdateShelterCommand(shelterId, shelterName)

fun shelterDetails() =
    ShelterDetails.create(shelterName)

fun shelterUpdatedEvent() =
    ShelterUpdatedEvent(shelterId, now, shelterDetails())