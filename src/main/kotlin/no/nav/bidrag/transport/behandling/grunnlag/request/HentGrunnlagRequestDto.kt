package no.nav.bidrag.transport.behandling.grunnlag.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty

// Request for å hente grunmnlag direkte fra bidrag-grunnlag uten å gå via grunnlagspakke og lagring i bidrag-grunnlag
data class HentGrunnlagRequestDto(
    @Schema(description = "Liste over hvilke typer grunnlag som skal hentes inn. På nivået under er personId og perioder angitt")
    @field:Valid
    @field:NotEmpty(message = "Listen kan ikke være null eller tom.")
    val grunnlagRequestDtoListe: List<GrunnlagRequestDto>,
)
