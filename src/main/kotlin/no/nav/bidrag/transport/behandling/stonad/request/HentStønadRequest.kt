package no.nav.bidrag.transport.behandling.stonad.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.StønadType
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.string.Saksnummer

@Schema(description = "Request for å hente stønad som matcher angitte parametre")
data class HentStønadRequest(
    @Schema(description = "Stønadstype")
    val type: StønadType,

    @Schema(description = "Referanse til sak")
    val sak: Saksnummer,

    @Schema(description = "Personidenten til den som skal betale stønadem")
    val skyldner: PersonIdent,

    @Schema(description = "Personidenten til den som krever stønadem")
    val kravhaver: PersonIdent,
)
