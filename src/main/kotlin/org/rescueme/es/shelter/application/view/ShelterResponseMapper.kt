package org.rescueme.es.shelter.application.view

import org.rescueme.es.shelter.domain.view.ShelterView

fun ShelterView.toResponse() =
    ShelterResponse(
        id = id.asString(),
        // TODO("review null")
        details = ShelterDetailsResponse(details.name!!),
        location = ShelterLocationResponse(location.city.name)
    )
