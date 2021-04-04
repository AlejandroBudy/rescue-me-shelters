package org.rescueme.es.shelter.application.create

import org.rescueme.es.shared.command.domain.Command

data class CreateShelterCommand(
    val id: String,
    val name: String,
    val location: String
) : Command