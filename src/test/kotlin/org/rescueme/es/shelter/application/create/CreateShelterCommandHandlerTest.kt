package org.rescueme.es.shelter.application.create

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.create.ShelterCreator
import org.rescueme.es.shelter.utils.createShelterCommand
import org.rescueme.es.shelter.utils.shelterIdVO

class CreateShelterCommandHandlerTest : StringSpec({

    val creator = mockk<ShelterCreator>()
    val commandHandler = CreateShelterCommandHandler(creator)

    "should invoke creator to create shelter"{
        val command = createShelterCommand()
        every { creator.invoke(any(), any(), any()) } returns Unit

        commandHandler.on(command)

        verify(exactly = 1) { creator.invoke(any(), any(), any()) }

    }
})
