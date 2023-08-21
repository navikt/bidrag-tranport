package no.nav.bidrag.transport.beregning.forskudd.rest.request

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

// Grunnlag
@Schema(description = "Grunnlaget for en forskuddsberegning")
data class BeregnForskuddGrunnlag(
    @Schema(description = "Beregn forskudd fra-dato") val beregnDatoFra: LocalDate? = null,
    @Schema(description = "Beregn forskudd til-dato") val beregnDatoTil: LocalDate? = null,
    @Schema(description = "Periodisert liste over grunnlagselementer") val grunnlagListe: List<Grunnlag>? = null
) {
}

@Schema(description = "Grunnlag")
data class Grunnlag(
    @Schema(description = "Referanse") val referanse: String? = null,
    @Schema(description = "Type") val type: String? = null,
    @Schema(description = "Innhold") val innhold: JsonNode? = null
) {
}