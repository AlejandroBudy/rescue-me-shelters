package org.rescueme.es.shelter.infrastructure.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.utils.createShelterView

class ShelterViewJpaRepositoryTest : StringSpec({

    val jpaRepository = mockk<ShelterViewPersistenceRepository>()
    val repository = ShelterViewJpaRepository(jpaRepository)

    beforeEach { clearAllMocks() }

    "Should create shelter view"{
        val shelterView = createShelterView()

        every { jpaRepository.save(shelterView) } returns shelterView

        repository.create(shelterView)

        verify(exactly = 1) { jpaRepository.save(shelterView) }
    }

    "Should find all shelters"{
        val shelterView = createShelterView()
        val list = listOf(shelterView)

        every { jpaRepository.findAll() } returns list

        val actual = repository.findAll()

        actual shouldBe list

        verify(exactly = 1) { jpaRepository.findAll() }
    }

})
