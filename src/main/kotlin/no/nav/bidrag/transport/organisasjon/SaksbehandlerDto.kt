package no.nav.bidrag.organisasjon.dto

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.ident.SaksbehandlerId
import no.nav.bidrag.domene.string.Navn

data class SaksbehandlerDto(
    val ident: SaksbehandlerId,
    @Schema(description = "Saksbehandlers navn (med eventuelt fornavn bak komma)")
    val navn: Navn? = null,
)
