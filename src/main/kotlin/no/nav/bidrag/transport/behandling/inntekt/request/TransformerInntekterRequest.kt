package no.nav.bidrag.transport.behandling.inntekt.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.transport.behandling.grunnlag.response.SkattegrunnlagspostDto
import java.math.BigDecimal
import java.time.LocalDate

// TODO Legge til swagger-doc, default-verdier
// TODO Legge til evt. manuelle inntekter
// TODO Hva gjør vi med inntekter som ikke er i bruk?

data class TransformerInntekterRequest(
    @Schema(description = "Periodisert liste over inntekter fra Ainntekt")
    val ainntektsposter: List<Ainntektspost> = emptyList(),

    @Schema(description = "Periodisert liste over inntekter fra Sigrun")
    val skattegrunnlagsliste: List<SkattegrunnlagForLigningsår> = emptyList(),

    @Schema(description = "Periodisert liste over overgangsstønad")
    val overgangsstonadsliste: List<Overgangsstonad> = emptyList()
)

data class SkattegrunnlagForLigningsår(

    @Schema(description = "Årstall skattegrunnlaget gjelder for")
    val ligningsår: Int,

    @Schema(description = "Poster med skattegrunnlag")
    val skattegrunnlagsposter: List<SkattegrunnlagspostDto>
)

data class Ainntektspost(

    @Schema(description = "Perioden innteksposten er utbetalt YYYYMM")
    val utbetalingsperiode: String?,

    @Schema(description = "Fra-dato for opptjening")
    val opptjeningsperiodeFra: LocalDate?,

    @Schema(description = "Til-dato for opptjening")
    val opptjeningsperiodeTil: LocalDate?,

    @Schema(description = "Beskrivelse av inntekt")
    val beskrivelse: String?,

    @Schema(description = "Belop")
    val belop: BigDecimal
)

data class Overgangsstonad(

    @Schema(description = "Periode fra-dato")
    val periodeFra: LocalDate,

    @Schema(description = "Periode til-dato")
    val periodeTil: LocalDate?,

    @Schema(description = "Beløp overgangsstønad")
    val belop: BigDecimal
)
