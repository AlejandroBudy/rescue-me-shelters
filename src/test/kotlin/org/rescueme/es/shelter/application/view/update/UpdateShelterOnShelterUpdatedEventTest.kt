package org.rescueme.es.shelter.application.view.update

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.view.update.ShelterViewUpdater
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterIdVO
import org.rescueme.es.shelter.utils.shelterUpdatedEvent

class UpdateShelterOnShelterUpdatedEventTest : StringSpec({


    val updater = mockk<ShelterViewUpdater>()
    val updateOnEvent = UpdateShelterOnShelterUpdatedEvent(updater)

    "Should invoke updater on event" {
        val shelterUpdatedEvent = shelterUpdatedEvent()
        val shelterDetails = shelterUpdatedEvent.details

        every {
            updater.invoke(shelterIdVO, shelterDetails)
        } returns Unit

        updateOnEvent.on(shelterUpdatedEvent)

        verify(exactly = 1) { updater.invoke(shelterIdVO, shelterDetails) }
    }
})
