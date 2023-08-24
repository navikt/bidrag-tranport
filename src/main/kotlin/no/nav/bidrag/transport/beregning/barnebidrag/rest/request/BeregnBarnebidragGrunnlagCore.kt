package no.nav.bidrag.transport.beregning.barnebidrag.rest.request

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "Grunnlaget for en beregning av barnebidrag")
data class BeregnGrunnlag(
  @Schema(description = "Beregn fra-dato") val beregnDatoFra: LocalDate? = null,
  @Schema(description = "Beregn til-dato") val beregnDatoTil: LocalDate? = null,
  @Schema(description = "Periodisert liste over grunnlagselementer") val grunnlagListe: List<Grunnlag>? = null
)

@Schema(description = "Grunnlag")
data class Grunnlag(
  @Schema(description = "Referanse") val referanse: String? = null,
  @Schema(description = "Type") val type: String? = null,
  @Schema(description = "Innhold") val innhold: JsonNode? = null
)

@Schema(description = "Grunnlaget for en beregning av forholdsmessig fordeling")
data class BeregnGrunnlagFF(
  @Schema(description = "Beregn fra-dato") val beregnDatoFra: LocalDate? = null,
  @Schema(description = "Beregn til-dato") val beregnDatoTil: LocalDate? = null,
  @Schema(description = "Periodisert liste over grunnlagselementer") val grunnlagListe: List<GrunnlagFF>? = null
)

@Schema(description = "Grunnlag")
data class GrunnlagFF(
  @Schema(description = "Type") val type: String? = null,
  @Schema(description = "Innhold") val innhold: JsonNode? = null
)