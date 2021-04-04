package org.rescueme.es.shelter.adapter.create

import org.rescueme.es.shelter.application.create.CreateShelterCommand

data class CreateShelterRequest(
    val name: String,
    val location: String
)

fun CreateShelterRequest.createCommand(id: String) =
    CreateShelterCommand(id, name, location)
