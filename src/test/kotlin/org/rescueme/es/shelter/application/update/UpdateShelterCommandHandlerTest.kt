package org.rescueme.es.shelter.application.update

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.update.ShelterUpdater
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterIdVO
import org.rescueme.es.shelter.utils.updateShelterCommand

class UpdateShelterCommandHandlerTest : StringSpec({

    val updater = mockk<ShelterUpdater>()
    val commandHandler = UpdateShelterCommandHandler(updater)

    "Should invoke updater on command"{
        every {
            updater.invoke(
                shelterIdVO,
                any()
            )
        } returns Unit

        commandHandler.on(updateShelterCommand())

        verify(exactly = 1) {
            updater.invoke(
                shelterIdVO,
                any()
            )
        }
    }

})
