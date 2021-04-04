package org.rescueme.es.shelter.domain.update

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.Shelter
import org.rescueme.es.shelter.domain.ShelterNotFoundException
import org.rescueme.es.shelter.domain.ShelterRepository
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterIdVO

class ShelterUpdaterTest : StringSpec({


    val shelterRepository = mockk<ShelterRepository>()
    val shelterUpdater = ShelterUpdater(shelterRepository)
    val shelter = mockk<Shelter>()

    "Should load aggregate ok and update details ok"{
        val details = shelterDetails()
        every { shelterRepository.load(shelterIdVO) } returns shelter
        every { shelter.updateDetails(details) } returns Unit

        shelterUpdater.invoke(shelterIdVO, details)

        verify { shelter.updateDetails(details) }
    }

    "Should throw exception when aggregate is not found"{
        every { shelterRepository.load(shelterIdVO) } returns null

        shouldThrowExactly<ShelterNotFoundException> {
            shelterUpdater.invoke(shelterIdVO, shelterDetails())
        }

    }
})
