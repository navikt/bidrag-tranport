package no.nav.bidrag.transport.behandling.stonad.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.Stønadstype
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.streng.Saksnummer

@Schema(description = "Request for å hente stønad som matcher angitte parametre")
data class HentStønadRequest(
    @Schema(description = "Stønadstype")
    val type: Stønadstype,

    @Schema(description = "Referanse til sak")
    val sak: Saksnummer,

    @Schema(description = "Personidenten til den som skal betale stønadem")
    val skyldner: Personident,

    @Schema(description = "Personidenten til den som krever stønadem")
    val kravhaver: Personident,
)
