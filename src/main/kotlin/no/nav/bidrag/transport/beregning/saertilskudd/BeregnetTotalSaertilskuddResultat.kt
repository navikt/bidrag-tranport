package no.nav.bidrag.transport.beregning.saertilskudd

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.resultatkoder.ResultatKodeSaertilskudd
import no.nav.bidrag.transport.beregning.felles.Grunnlag
import no.nav.bidrag.transport.beregning.felles.Periode
import java.math.BigDecimal

data class BeregnetTotalSaertilskuddResultat(
    @Schema(description = "Periodisert liste over resultat av særtilskuddsberegning") var beregnetSaertilskuddPeriodeListe: List<ResultatPeriode> = emptyList(),
    @Schema(description = "Liste over grunnlag brukt i beregning") var grunnlagListe: List<Grunnlag> = emptyList()
)

@Schema(description = "Resultatet av en beregning for en gitt periode")
data class ResultatPeriode(
    @Schema(description = "Søknadsbarn") var barn: Int = 0,
    @Schema(description = "Beregnet resultat periode") var periode: Periode,
    @Schema(description = "Beregnet resultat innhold") var resultat: ResultatBeregning,
    @Schema(description = "Beregnet grunnlag innhold") var grunnlagReferanseListe: List<String>
)

@Schema(description = "Resultatet av en beregning")
data class ResultatBeregning(
    @Schema(description = "Resultat beløp") var belop: BigDecimal,
    @Schema(description = "Resultat kode") var kode: ResultatKodeSaertilskudd
)
