package org.rescueme.es.shelter.application.update

import org.axonframework.commandhandling.CommandHandler
import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.update.ShelterUpdater
import org.springframework.stereotype.Component

@Component
open class UpdateShelterCommandHandler(private val updater: ShelterUpdater) {

    @CommandHandler
    fun on(command: UpdateShelterCommand) {
        updater(
            ShelterId.fromString(command.id),
            ShelterDetails.create(command.name)
        )
    }

}