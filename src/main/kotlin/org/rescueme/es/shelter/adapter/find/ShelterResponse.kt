package org.rescueme.es.shelter.adapter.find

import org.rescueme.es.shelter.application.view.ShelterDetailsResponse
import org.rescueme.es.shelter.application.view.ShelterLocationResponse
import org.rescueme.es.shelter.application.view.ShelterResponse

data class ShelterRestResponse(
    val identifier: String,
    val details: ShelterDetailsRestResponse,
    val location: ShelterLocationRestResponse
)

data class ShelterDetailsRestResponse(val name: String)
data class ShelterLocationRestResponse(val city: String)

fun ShelterResponse.toRestResponse() =
    ShelterRestResponse(
        identifier = id,
        details = details.toRestResponse(),
        location = location.toRestResponse()
    )

fun ShelterDetailsResponse.toRestResponse() = ShelterDetailsRestResponse(name)
fun ShelterLocationResponse.toRestResponse() = ShelterLocationRestResponse(city)

