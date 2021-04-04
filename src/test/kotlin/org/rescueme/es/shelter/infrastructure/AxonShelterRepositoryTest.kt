package org.rescueme.es.shelter.infrastructure

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.axonframework.commandhandling.model.Aggregate
import org.axonframework.commandhandling.model.Repository
import org.rescueme.es.shelter.domain.Shelter
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterId
import org.rescueme.es.shelter.utils.shelterIdVO
import org.rescueme.es.shelter.utils.shelterLocation
import java.util.function.Function

class AxonShelterRepositoryTest : StringSpec({

    val aggregateRepository = mockk<Repository<Shelter>>()
    val repository = AxonShelterRepository(aggregateRepository)
    val shelter = mockk<Shelter>()
    val aggregate = mockk<Aggregate<Shelter>>()


    "Should instance new aggregate"{
        every { aggregateRepository.newInstance(any()) } returns aggregate

        repository.new(shelterIdVO, shelterDetails, shelterLocation)

        verify(exactly = 1) { aggregateRepository.newInstance(any()) }
    }

//    "Should load aggregate ok"{
//
//        every { aggregateRepository.load(shelterId) } returns aggregate
//        every { aggregate.invoke { any<Shelter>() } } returns shelter
//        val actual = repository.load(shelterIdVO)
//
//        actual shouldBe shelter
//
//        verify(exactly = 1) { aggregateRepository.load(shelterId) }
//
//    }

})
