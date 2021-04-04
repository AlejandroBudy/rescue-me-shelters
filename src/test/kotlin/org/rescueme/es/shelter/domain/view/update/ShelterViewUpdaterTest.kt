package org.rescueme.es.shelter.domain.view.update

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.rescueme.es.shelter.utils.shelterDetails
import org.rescueme.es.shelter.utils.shelterIdVO

class ShelterViewUpdaterTest : StringSpec({

    val repository = mockk<ShelterViewRepository>()
    val updater = ShelterViewUpdater(repository)

    "Should update view in repository"{
        val details = shelterDetails()

        every { repository.update(shelterIdVO, details) } returns Unit

        updater.invoke(shelterIdVO, details)

        verify(exactly = 1) { repository.update(shelterIdVO, details) }
    }

})
