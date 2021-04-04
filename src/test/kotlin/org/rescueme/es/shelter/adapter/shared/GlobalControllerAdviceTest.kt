package org.rescueme.es.shelter.adapter.shared

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.rescueme.es.shelter.domain.ShelterNotFoundException
import org.springframework.http.ResponseEntity

class GlobalControllerAdviceTest : StringSpec({

    val controllerAdvice = GlobalControllerAdvice()

    "Should map ShelterNotFoundException exception ok" {
        controllerAdvice.on(ShelterNotFoundException("")) shouldBe ResponseEntity.notFound().build()
    }

    "Should map IllegalArgumentException exception ok" {
        controllerAdvice.on(IllegalArgumentException("")) shouldBe ResponseEntity.badRequest().build()
    }

})
