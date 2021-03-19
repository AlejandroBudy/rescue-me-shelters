package org.rescueme.es.shelter.infrastructure.view

import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.view.ShelterView
import org.rescueme.es.shelter.domain.view.ShelterViewRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
open class ShelterViewJpaRepository(private val jpaRepository: ShelterViewPersistenceRepository) :
    ShelterViewRepository {

    override fun create(shelterView: ShelterView) {
        jpaRepository.save(shelterView)
    }

    override fun findAll(): List<ShelterView> =
        jpaRepository.findAll()

}

interface ShelterViewPersistenceRepository : JpaRepository<ShelterView, ShelterId>