package org.rescueme.es.shelter.infrastructure.view

import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.view.ShelterView
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
open class ShelterViewJpaRepository(private val jpaRepository: ShelterViewPersistenceRepository) :
    ShelterViewRepository {

    override fun create(shelterView: ShelterView) {
        jpaRepository.save(shelterView)
    }

    override fun findAll(): List<ShelterView> =
        jpaRepository.findAll()

    override fun update(shelterId: ShelterId, shelterDetails: ShelterDetails) {
        jpaRepository.findByIdOrNull(shelterId)
            ?.also { it.details = shelterDetails }
            ?.let { jpaRepository.save(it) }
            .also { it ?: println("Dog view $shelterId not found for update") }
    }

}

interface ShelterViewPersistenceRepository : JpaRepository<ShelterView, ShelterId>