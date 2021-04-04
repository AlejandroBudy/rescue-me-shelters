package org.rescueme.es.shelter.adapter.update

import org.rescueme.es.shared.command.domain.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateShelterController(private val commandBus: CommandBus) {

    @PutMapping("/shelter/{uuid}")
    fun updateShelter(
        @PathVariable uuid: String,
        @RequestBody shelter: UpdateShelterRequest
    ): ResponseEntity<Unit> {
        val command = shelter.createCommand(uuid)
        commandBus.dispatch(command)
        return ResponseEntity.accepted().build()
    }


}