package org.rescueme.es.shelter.adapter.update

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.rescueme.es.shared.command.domain.CommandBus
import org.rescueme.es.shelter.utils.shelterId
import org.rescueme.es.shelter.utils.updateShelterCommand
import org.rescueme.es.shelter.utils.updateShelterRequest
import org.springframework.http.ResponseEntity

class UpdateShelterControllerTest : StringSpec({

    val commandBus = mockk<CommandBus>()
    val controller = UpdateShelterController(commandBus)


    "Should update shelter ok"{
        every { commandBus.dispatch(updateShelterCommand()) } returns Unit

        val actual = controller.updateShelter(shelterId, updateShelterRequest())

        actual shouldBe ResponseEntity.accepted().build()
    }

})
