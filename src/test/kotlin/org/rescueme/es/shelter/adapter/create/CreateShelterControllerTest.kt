package org.rescueme.es.shelter.adapter.create

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shared.command.domain.CommandBus
import org.rescueme.es.shelter.utils.createShelterRequest
import org.springframework.http.HttpStatus

class CreateShelterControllerTest : BehaviorSpec({

    val commandBus = mockk<CommandBus>()
    val controller = CreateShelterController(commandBus)

    given("Create shelter controller") {
        val request = createShelterRequest()
        every { commandBus.dispatch(any()) } returns Unit
        `when`("Controller receives a request to create shelter") {
            val actual = controller.createShelter(request)
            then("Shelter is created") {
                actual.statusCode shouldBe HttpStatus.CREATED
                verify(exactly = 1) { commandBus.dispatch(any()) }
            }
        }

    }


})
