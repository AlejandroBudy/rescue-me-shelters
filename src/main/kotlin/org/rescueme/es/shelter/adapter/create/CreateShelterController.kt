package org.rescueme.es.shelter.adapter.create

import org.rescueme.es.shared.command.domain.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
class CreateShelterController(private val commandBus: CommandBus) {

    @PostMapping("/shelter")
    fun createShelter(@RequestBody shelter: CreateShelterRequest): ResponseEntity<Unit> {
        val shelterId = UUID.randomUUID().toString()
        commandBus.dispatch(shelter.createCommand(shelterId))
        return ResponseEntity.created(URI("/shelter/$shelterId")).build()
    }
}