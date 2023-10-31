package no.nav.bidrag.transport.behandling.stonad.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.StønadType
import no.nav.bidrag.domene.ident.PersonIdent
import no.nav.bidrag.domene.string.Saksnummer
import java.time.LocalDateTime

@Schema(description = "Request for å hente stønad og perioder som var gyldige på angitt tidspunkt")
data class HentStønadHistoriskRequest(
    @Schema(description = "Stønadstype")
    val type: StønadType,

    @Schema(description = "Referanse til sak")
    val sak: Saksnummer,

    @Schema(description = "Personidenten til den som skal betale stønadem")
    val skyldner: PersonIdent,

    @Schema(description = "Personidenten til den som krever stønadem")
    val kravhaver: PersonIdent,

    @Schema(description = "Tidspunkt som det ønskes å hente gyldige perioder for")
    val gyldigTidspunkt: LocalDateTime,
)
