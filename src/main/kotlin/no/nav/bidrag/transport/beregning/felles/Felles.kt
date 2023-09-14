package no.nav.bidrag.transport.beregning.felles

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.GrunnlagType
import java.math.BigDecimal
import java.time.LocalDate

// Felles

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

interface IResultatPeriode {
    val periode: PeriodeCore
    val grunnlagReferanseListe: List<String>
}

@Schema(description = "Periode (fra-til dato")
data class Periode(
    @Schema(description = "Fra-og-med-dato") var datoFom: LocalDate? = null,
    @Schema(description = "Til-dato") var datoTil: LocalDate? = null
) {

    constructor(periode: PeriodeCore) : this(
        datoFom = periode.datoFom,
        datoTil = periode.datoTil
    )
}

data class PeriodeCore(
    val datoFom: LocalDate,
    val datoTil: LocalDate?
)

data class SjablonPeriodeCore(
    val periode: PeriodeCore,
    val navn: String,
    val nokkelListe: List<SjablonNokkelCore>? = emptyList(),
    val innholdListe: List<SjablonInnholdCore>
)

data class SjablonCore(
    val navn: String,
    val nokkelListe: List<SjablonNokkelCore>? = emptyList(),
    val innholdListe: List<SjablonInnholdCore>
)

data class SjablonNokkelCore(
    val navn: String,
    val verdi: String
)

data class SjablonInnholdCore(
    val navn: String,
    val verdi: BigDecimal
)

data class SjablonNavnVerdiCore(
    val navn: String,
    val verdi: BigDecimal
)

data class SjablonResultatGrunnlagCore(
    val referanse: String,
    val periode: PeriodeCore,
    val navn: String,
    val verdi: BigDecimal
)

data class AvvikCore(
    val avvikTekst: String,
    val avvikType: String
)
