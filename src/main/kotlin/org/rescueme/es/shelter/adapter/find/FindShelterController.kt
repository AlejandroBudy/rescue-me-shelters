package org.rescueme.es.shelter.adapter.find


import org.rescueme.es.shared.query.domain.QueryBus
import org.rescueme.es.shared.query.domain.ask
import org.rescueme.es.shelter.application.view.ShelterResponse
import org.rescueme.es.shelter.domain.view.find.FindSheltersQuery
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
class FindShelterController(private val queryBus: QueryBus) {

    @GetMapping("/shelter")
    fun findShelters(): CompletableFuture<ResponseEntity<List<ShelterRestResponse>>> {
        return queryBus.ask<List<ShelterResponse>>(FindSheltersQuery())
            .thenApply { list ->
                list.asSequence()
                    .map { it.toRestResponse() }
                    .toList()
            }
            .thenApply { ResponseEntity.ok(it) }
            .exceptionally { ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() }
    }
}