package org.rescueme.es.shelter.adapter.shared

import org.rescueme.es.shelter.domain.ShelterNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(ShelterNotFoundException::class)
    fun on(exception: ShelterNotFoundException) =
        ResponseEntity.notFound().build<Unit>()
            .also { println("Error not found shelter") }

    @ExceptionHandler(IllegalArgumentException::class)
    fun on(exception: IllegalArgumentException) =
        ResponseEntity.badRequest().build<Unit>()
            .also { println("Error illegal argument") }
}