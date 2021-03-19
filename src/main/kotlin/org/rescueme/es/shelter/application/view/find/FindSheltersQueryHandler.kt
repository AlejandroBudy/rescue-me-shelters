package org.rescueme.es.shelter.application.view.find

import org.axonframework.queryhandling.QueryHandler
import org.rescueme.es.shelter.application.view.toResponse
import org.rescueme.es.shelter.domain.view.find.FindSheltersQuery
import org.rescueme.es.shelter.domain.view.find.SheltersFinder
import org.springframework.stereotype.Component

@Component
open class FindSheltersQueryHandler(private val finder: SheltersFinder) {

    @QueryHandler
    fun on(query: FindSheltersQuery) =
        finder().asSequence()
            .map { it.toResponse() }
            .toList()
}