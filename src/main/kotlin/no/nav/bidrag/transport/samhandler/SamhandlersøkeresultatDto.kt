package no.nav.bidrag.transport.samhandler

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.bool.FlereForekomster

@Schema(description = "Søkeresultat etter søk på samhandler.")
data class SamhandlersøkeresultatDto(
    val samhandlere: List<SamhandlerDto>,
    @Schema(description = "True hvis det finnes flere forekomster enn det som er returnert i dette objektet.")
    val flereForekomster: FlereForekomster,
)
