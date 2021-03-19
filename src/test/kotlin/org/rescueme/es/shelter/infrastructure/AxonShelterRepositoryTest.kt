package org.rescueme.es.shelter.infrastructure

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.axonframework.commandhandling.model.Aggregate
import org.axonframework.commandhandling.model.Repository
import org.rescueme.es.shelter.domain.Shelter
import org.rescueme.es.shelter.utils.shelterIdVO

class AxonShelterRepositoryTest : StringSpec({

    val aggregateRepository = mockk<Repository<Shelter>>()
    val repository = AxonShelterRepository(aggregateRepository)

    "Should instance new aggregate"{
        val aggregate = mockk<Aggregate<Shelter>>()
        every { aggregateRepository.newInstance(any()) } returns aggregate

        repository.new(shelterIdVO)

        verify(exactly = 1) { aggregateRepository.newInstance(any()) }
    }

})
