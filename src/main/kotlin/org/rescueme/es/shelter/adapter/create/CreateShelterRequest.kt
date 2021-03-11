package org.rescueme.es.shelter.adapter.create

import org.rescueme.es.shelter.application.create.CreateShelterCommand

data class CreateShelterRequest(val name: String)

fun createCommand(id: String) =
    CreateShelterCommand(id)
