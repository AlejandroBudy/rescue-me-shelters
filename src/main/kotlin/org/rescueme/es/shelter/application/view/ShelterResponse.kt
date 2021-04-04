package org.rescueme.es.shelter.application.view

data class ShelterResponse(val id: String, val details: ShelterDetailsResponse, val location: ShelterLocationResponse)
data class ShelterDetailsResponse(val name: String)
data class ShelterLocationResponse(val city: String)