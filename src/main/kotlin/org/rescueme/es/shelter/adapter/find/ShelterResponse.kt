package org.rescueme.es.shelter.adapter.find

import org.rescueme.es.shelter.application.view.ShelterResponse

data class ShelterRestResponse(
    val identifier: String
)

fun ShelterResponse.toRestResponse() =
    ShelterRestResponse(identifier = id)

