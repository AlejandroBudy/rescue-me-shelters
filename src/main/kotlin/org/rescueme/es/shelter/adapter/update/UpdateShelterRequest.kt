package org.rescueme.es.shelter.adapter.update

import org.rescueme.es.shelter.application.update.UpdateShelterCommand

data class UpdateShelterRequest(
    val name: String
)

fun UpdateShelterRequest.createCommand(id: String) =
    UpdateShelterCommand(id, name)