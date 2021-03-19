package org.rescueme.es.shelter.infrastructure


import org.rescueme.es.shelter.domain.Shelter
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.ShelterRepository
import org.springframework.stereotype.Repository
import org.axonframework.commandhandling.model.Repository as AggregateRepository

@Repository
open class AxonShelterRepository(private val persistenceRepository: AggregateRepository<Shelter>) : ShelterRepository {
    override fun new(shelterId: ShelterId) {
        persistenceRepository.newInstance {
            Shelter.create(shelterId)
            Shelter()
        }
    }

}