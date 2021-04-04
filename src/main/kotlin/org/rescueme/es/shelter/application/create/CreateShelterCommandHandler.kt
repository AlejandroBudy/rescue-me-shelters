package org.rescueme.es.shelter.application.create

import org.axonframework.commandhandling.CommandHandler
import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.ShelterLocation
import org.rescueme.es.shelter.domain.create.ShelterCreator
import org.springframework.stereotype.Component

@Component
open class CreateShelterCommandHandler(private val creator: ShelterCreator) {

    @CommandHandler
    fun on(command: CreateShelterCommand) {
        creator(
            shelterId = ShelterId.fromString(command.id),
            shelterDetails = ShelterDetails.create(command.name),
            shelterLocation = ShelterLocation.createLocation(name = command.location)
        )
    }
}