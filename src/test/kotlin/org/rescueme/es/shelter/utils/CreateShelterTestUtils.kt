package org.rescueme.es.shelter.utils

import org.rescueme.es.shelter.adapter.create.CreateShelterRequest
import org.rescueme.es.shelter.application.create.CreateShelterCommand
import org.rescueme.es.shelter.domain.ShelterId


const val shelterId: String = "15708b33-e1ad-4a4b-bb0a-af3c1307ab01"

val shelterIdVO = ShelterId.fromString(shelterId)

fun createShelterRequest() =
    CreateShelterRequest(shelterId)

fun createShelterCommand() =
    CreateShelterCommand(shelterId)