package org.rescueme.es.shelter.domain.view

import org.hibernate.annotations.DynamicUpdate
import org.rescueme.es.shared.noargs.NoArgsConstructor
import org.rescueme.es.shelter.domain.ShelterDetails
import org.rescueme.es.shelter.domain.ShelterId
import org.rescueme.es.shelter.domain.ShelterLocation
import java.io.Serializable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@DynamicUpdate
@NoArgsConstructor
data class ShelterView(
    @Embedded @Id var id: ShelterId,
    @Embedded var details: ShelterDetails,
    @Embedded var location: ShelterLocation
) : Serializable