package no.nav.bidrag.transport.behandling.inntekt.response

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.InntektBeskrivelse
import java.math.BigDecimal
import java.time.YearMonth

data class TransformerInntekterResponseDto(
    @Schema(description = "Dato + commit hash", example = "20230705081501_68e71c7")
    val versjon: String = "",

    @Schema(description = "Liste over summerte månedsinntekter (Ainntekt ++))")
    val summertMaanedsinntektListe: List<SummertMaanedsinntekt> = emptyList(),

    @Schema(description = "Liste over summerte årsinntekter (Ainntekt + Sigrun ++)")
    val summertAarsinntektListe: List<SummertAarsinntekt> = emptyList()
)

data class SummertMaanedsinntekt(
    @Schema(description = "Periode (YYYYMM)", example = "202301")
    val periode: YearMonth,

    @Schema(description = "Summert inntekt for måneden", example = "50000")
    val sumInntekt: BigDecimal,

    @Schema(description = "Liste over inntektsposter som utgjør grunnlaget for summert inntekt")
    val inntektPostListe: List<InntektPost>
)

data class SummertAarsinntekt(
    @Schema(description = "Beskrivelse av inntekt", example = "LIGNINGSINNTEKT")
    val inntektBeskrivelse: InntektBeskrivelse,

    @Schema(description = "Visningsnavn for inntekt", example = "Ligningsinntekt")
    val visningsnavn: String,

    @Schema(description = "Referanse", example = "Referanse")
    val referanse: String,

    @Schema(description = "Summert inntekt for perioden, omgjort til årsinntekt", example = "600000")
    val sumInntekt: BigDecimal,

    @Schema(description = "Periode (YYYYMM) som inntekten gjelder fra", example = "202301")
    val periodeFra: YearMonth,

    @Schema(description = "Periode (YYYYMM) som inntekten gjelder til", example = "202312")
    val periodeTil: YearMonth?,

    @Schema(description = "Liste over inntektsposter (generisk, avhengig av type) som utgjør grunnlaget for summert inntekt")
    val inntektPostListe: List<InntektPost>
)
data class InntektPost(
    @Schema(description = "Kode for inntektspost", example = "bonus")
    val kode: String,

    @Schema(description = "Visningsnavn for kode", example = "Bonus")
    val visningsnavn: String,

    @Schema(description = "Beløp som utgør inntektsposten", example = "60000")
    val beløp: BigDecimal
)
