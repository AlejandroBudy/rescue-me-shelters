package org.rescueme.es.shelter.application.view.find

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.rescueme.es.shelter.application.view.ShelterResponse
import org.rescueme.es.shelter.domain.view.ShelterView
import org.rescueme.es.shelter.domain.view.find.FindSheltersQuery
import org.rescueme.es.shelter.domain.view.find.SheltersFinder
import org.rescueme.es.shelter.utils.createShelterResponse
import org.rescueme.es.shelter.utils.createShelterView

class FindSheltersQueryHandlerTest : StringSpec({

    val finder = mockk<SheltersFinder>()
    val handler = FindSheltersQueryHandler(finder)

    "Should handle query invoking finder to return list"{
        val sheltersList = listOf(createShelterView(), createShelterView())
        val expectedList = listOf(createShelterResponse(), createShelterResponse())

        every { finder.invoke() } returns sheltersList

        val actual = handler.on(FindSheltersQuery())

        actual shouldBe expectedList

    }

    "Should handle query invoking finder to return empty list"{
        val sheltersList = listOf<ShelterView>()
        val expectedList = listOf<ShelterResponse>()

        every { finder.invoke() } returns sheltersList

        val actual = handler.on(FindSheltersQuery())

        actual shouldBe expectedList

    }

})
