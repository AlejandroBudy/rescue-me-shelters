package org.rescueme.es.shelter.application.view.create

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.view.create.ShelterViewCreator
import org.rescueme.es.shelter.utils.createShelterCreatedEvent
import org.rescueme.es.shelter.utils.shelterIdVO

class CreateShelterViewOnShelterCreatedEventTest : StringSpec({

    val creator = mockk<ShelterViewCreator>()
    val handler = CreateShelterViewOnShelterCreatedEvent(creator)

    "Should create shelter view on event"{
        val event = createShelterCreatedEvent()

        every { creator.invoke(shelterIdVO) } returns Unit

        handler.on(event)

        verify(exactly = 1) { creator.invoke(shelterIdVO) }

    }

})
