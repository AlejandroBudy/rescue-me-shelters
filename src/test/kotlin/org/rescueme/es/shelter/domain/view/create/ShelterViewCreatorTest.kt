package org.rescueme.es.shelter.domain.view.create

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.rescueme.es.shelter.utils.createShelterView
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterIdVO
import org.rescueme.es.shelter.utils.shelterLocation

class ShelterViewCreatorTest : StringSpec({

    val repository = mockk<ShelterViewRepository>()
    val creator = ShelterViewCreator(repository)

    "Should invoke repository to create shelter view"{

        every { repository.create(createShelterView()) } returns Unit

        creator.invoke(shelterIdVO, shelterDetails, shelterLocation)

        verify(exactly = 1) { repository.create(createShelterView()) }
    }

})
