package no.nav.bidrag.organisasjon.dto

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.ident.SaksbehandlerId
import no.nav.bidrag.domain.string.Navn

data class SaksbehandlerDto(
    val ident: SaksbehandlerId,
    @Schema(description = "Saksbehandlers navn (med eventuelt fornavn bak komma)")
    val navn: Navn? = null,
)
