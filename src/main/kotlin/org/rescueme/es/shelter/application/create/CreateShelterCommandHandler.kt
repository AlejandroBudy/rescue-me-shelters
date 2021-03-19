package org.rescueme.es.shelter.application.create

import org.axonframework.commandhandling.CommandHandler
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.create.ShelterCreator
import org.springframework.stereotype.Component

@Component
open class CreateShelterCommandHandler(private val creator: ShelterCreator) {

    @CommandHandler
    fun on(command: CreateShelterCommand) {
        creator(ShelterId.fromString(command.id))
    }
}