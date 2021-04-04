package org.rescueme.es.shelter.domain.create

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.ShelterRepository
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterIdVO
import org.rescueme.es.shelter.utils.shelterLocation

class ShelterCreatorTest : StringSpec({

    val repository = mockk<ShelterRepository>()
    val creator = ShelterCreator(repository)

    "Should invoke repository to create new aggregate"() {
        every { repository.new(shelterIdVO, shelterDetails, shelterLocation) } returns Unit

        creator.invoke(shelterIdVO, shelterDetails, shelterLocation)

        verify(exactly = 1) { repository.new(shelterIdVO, shelterDetails, shelterLocation) }
    }
})
