package org.rescueme.es.shelter.application.update

import org.rescueme.es.shared.command.domain.Command

data class UpdateShelterCommand(
    val id: String,
    val name: String
) : Command