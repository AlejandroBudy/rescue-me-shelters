package org.rescueme.es.shelter.domain.view.find

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.rescueme.es.shelter.utils.createShelterView

class SheltersFinderTest : StringSpec({

    val repository = mockk<ShelterViewRepository>()
    val finder = SheltersFinder(repository)

    "Should invoke repository and return list of shelter"{
        val shelterList = listOf(createShelterView(), createShelterView())

        every { repository.findAll() } returns shelterList

        val actual = finder.invoke()

        actual shouldBe shelterList

        verify(exactly = 1) { repository.findAll() }
    }

})
