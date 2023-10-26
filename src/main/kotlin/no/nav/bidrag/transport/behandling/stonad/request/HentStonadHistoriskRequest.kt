package no.nav.bidrag.transport.behandling.stonad.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.StonadType
import java.time.LocalDateTime

@Schema(description = "Request for å hente stønad og perioder som var gyldige på angitt tidspunkt")
data class HentStonadHistoriskRequest(
    @Schema(description = "Stønadstype")
    val type: StonadType,

    @Schema(description = "Referanse til sak")
    val sakId: String,

    @Schema(description = "Id til den som skal betale stønadem")
    val skyldnerId: String,

    @Schema(description = "Id til den som krever stønadem")
    val kravhaverId: String,

    @Schema(description = "Tidspunkt som det ønskes å hente gyldige perioder for")
    val gyldigTidspunkt: LocalDateTime,
)
