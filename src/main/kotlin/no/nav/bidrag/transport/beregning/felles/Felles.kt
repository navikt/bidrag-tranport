package no.nav.bidrag.transport.beregning.felles

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.GrunnlagType
import java.time.LocalDate


@Schema(description = "Grunnlaget for en beregning av barnebidrag, forskudd og særtilskudd")
data class BeregnGrunnlag(
    @Schema(description = "Beregn fra-dato") val beregnDatoFra: LocalDate? = null,
    @Schema(description = "Beregn til-dato") val beregnDatoTil: LocalDate? = null,
    @Schema(description = "Periodisert liste over grunnlagselementer") val grunnlagListe: List<Grunnlag>? = null
)

@Schema(description = "Grunnlag")
data class Grunnlag(
    @Schema(description = "Referanse") val referanse: String? = null,
    @Schema(description = "Type") val type: GrunnlagType? = null,
    @Schema(description = "Innhold") val innhold: JsonNode? = null
)

@Schema(description = "Periode (fra-til dato")
data class Periode(
    @Schema(description = "Fra-og-med-dato") var datoFom: LocalDate? = null,
    @Schema(description = "Til-dato") var datoTil: LocalDate? = null
)