package org.rescueme.es.shelter.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.util.*
import javax.persistence.Column

@ValueObject
data class ShelterDetails(
    private var id_: UUID?,
    private val name_: String
) {

    @Column(columnDefinition = "binary(16)", name = "specification")
    val id: UUID = id_ ?: UUID.randomUUID()
    var name: String? = name_
        private set

    fun update(details: ShelterDetails) {
        name = if (details.name != null) details.name else name
    }

    companion object {
        fun create(name: String) =
            ShelterDetails(
                id_ = UUID.randomUUID(),
                name_ = name
            )
    }
}