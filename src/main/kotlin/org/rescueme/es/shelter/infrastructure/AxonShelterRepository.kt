package org.rescueme.es.shelter.infrastructure


import org.axonframework.commandhandling.model.Aggregate
import org.rescueme.es.shelter.domain.*
import org.springframework.stereotype.Repository
import org.axonframework.commandhandling.model.Repository as AggregateRepository

@Repository
open class AxonShelterRepository(private val persistenceRepository: AggregateRepository<Shelter>) : ShelterRepository {
    override fun new(
        shelterId: ShelterId,
        shelterDetails: ShelterDetails,
        shelterLocation: ShelterLocation
    ) {
        persistenceRepository.newInstance {
            Shelter.create(shelterId, shelterDetails, shelterLocation)
            Shelter()
        }
    }

    override fun load(shelterId: ShelterId) = try {
        val aggregate: Aggregate<Shelter> =
            persistenceRepository.load(shelterId.asString())
        aggregate.invoke { it }
    } catch (thr: Throwable) {
        println(thr)
        null
    }


}