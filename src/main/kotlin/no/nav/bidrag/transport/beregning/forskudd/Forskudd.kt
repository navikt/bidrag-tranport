package no.nav.bidrag.transport.beregning.forskudd

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.resultatkoder.ResultatKodeForskudd
import no.nav.bidrag.transport.beregning.felles.Grunnlag
import no.nav.bidrag.transport.beregning.felles.Periode
import java.math.BigDecimal

// Resultat
@Schema(description = "Resultatet av en forskuddsberegning")
data class BeregnetForskuddResultat(
    @Schema(description = "Periodisert liste over resultat av forskuddsberegning") var beregnetForskuddPeriodeListe: List<ResultatPeriode> = emptyList(),
    @Schema(description = "Liste over grunnlag brukt i beregning") var grunnlagListe: List<Grunnlag> = emptyList(),
)

@Schema(description = "Resultatet av en beregning for en gitt periode")
data class ResultatPeriode(
    @Schema(description = "Beregnet resultat periode") var periode: Periode,
    @Schema(description = "Beregnet resultat innhold") var resultat: ResultatBeregning,
    @Schema(description = "Beregnet grunnlag innhold") var grunnlagReferanseListe: List<String>,
)

@Schema(description = "Resultatet av en beregning")
data class ResultatBeregning(
    @Schema(description = "Resultat beløp") var belop: BigDecimal,
    @Schema(description = "Resultat kode") var kode: ResultatKodeForskudd,
    @Schema(description = "Resultat regel") var regel: String,
)
