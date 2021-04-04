package org.rescueme.es.shelter.infrastructure.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.exactly
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.utils.createShelterView
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterIdVO
import org.springframework.data.repository.findByIdOrNull

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

    "Should update shelter when is present" {
        val details = shelterDetails()
        val shelterView = createShelterView()
        val shelterUpdated = shelterView.copy().also { it.details = details }

        every { jpaRepository.findByIdOrNull(shelterIdVO) } returns shelterView
        every { jpaRepository.save(shelterUpdated) } returns shelterUpdated

        repository.update(shelterIdVO, details)

        verify { jpaRepository.findByIdOrNull(shelterIdVO) }
        verify { jpaRepository.save(shelterUpdated) }
    }

    "Should not update shelter when is not present" {
        val details = shelterDetails()

        every { jpaRepository.findByIdOrNull(shelterIdVO) } returns null

        repository.update(shelterIdVO, details)

        verify { jpaRepository.findByIdOrNull(shelterIdVO) }
        verify(exactly = 0) { jpaRepository.save(any()) }
    }

})
