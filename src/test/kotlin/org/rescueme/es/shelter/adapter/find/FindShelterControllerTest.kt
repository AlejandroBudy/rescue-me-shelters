package org.rescueme.es.shelter.adapter.find

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shared.query.domain.QueryBus
import org.rescueme.es.shared.query.domain.ask
import org.rescueme.es.shelter.application.view.ShelterResponse
import org.rescueme.es.shelter.utils.createShelterResponse
import org.rescueme.es.shelter.utils.createShelterRestResponse
import org.springframework.http.HttpStatus
import java.util.concurrent.CompletableFuture

class FindShelterControllerTest : StringSpec({

    val queryBus = mockk<QueryBus>()
    val controller = FindShelterController(queryBus)

    beforeEach { clearAllMocks() }

    "Should Query bus and return list of shelters" {
        val responseList = listOf(createShelterResponse(), createShelterResponse())
        val expectedList = listOf(createShelterRestResponse(), createShelterRestResponse())

        every { queryBus.ask<List<ShelterResponse>>(any()) } returns
                CompletableFuture.supplyAsync { responseList }

        val actual = controller.findShelters().join()

        actual.statusCode shouldBe HttpStatus.OK
        actual.body shouldBe expectedList

        verify(exactly = 1) { queryBus.ask<List<ShelterResponse>>(any()) }
    }

    "Should Query bus and return empty list" {
        val responseList = emptyList<ShelterResponse>()
        val expectedList = emptyList<ShelterRestResponse>()

        every { queryBus.ask<List<ShelterResponse>>(any()) } returns
                CompletableFuture.supplyAsync { responseList }

        val actual = controller.findShelters().join()

        actual.statusCode shouldBe HttpStatus.OK
        actual.body shouldBe expectedList

        verify(exactly = 1) { queryBus.ask<List<ShelterResponse>>(any()) }
    }

    "Should Query bus and return error when exception is thrown" {

        every { queryBus.ask<List<ShelterResponse>>(any()) } returns
                CompletableFuture.failedFuture(RuntimeException())

        val actual = controller.findShelters().join()

        actual.statusCode shouldBe HttpStatus.INTERNAL_SERVER_ERROR

        verify(exactly = 1) { queryBus.ask<List<ShelterResponse>>(any()) }
    }
})
