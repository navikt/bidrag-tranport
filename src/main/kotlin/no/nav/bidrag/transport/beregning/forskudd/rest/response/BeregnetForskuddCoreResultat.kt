package no.nav.bidrag.transport.beregning.forskudd.rest.response

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.transport.beregning.felles.Periode
import no.nav.bidrag.transport.beregning.forskudd.core.response.BeregnetForskuddResultatCore
import no.nav.bidrag.transport.beregning.forskudd.core.response.ResultatBeregningCore
import no.nav.bidrag.transport.beregning.forskudd.core.response.ResultatPeriodeCore
import java.math.BigDecimal

// Resultat
@Schema(description = "Resultatet av en forskuddsberegning")
data class BeregnetForskuddResultat(
    @Schema(description = "Periodisert liste over resultat av forskuddsberegning") var beregnetForskuddPeriodeListe: List<ResultatPeriode> = emptyList(),
    @Schema(description = "Liste over grunnlag brukt i beregning") var grunnlagListe: List<ResultatGrunnlag> = emptyList()
) {

    constructor(beregnetForskuddResultat: BeregnetForskuddResultatCore, grunnlagListe: List<ResultatGrunnlag>) : this(
        beregnetForskuddPeriodeListe = beregnetForskuddResultat.beregnetForskuddPeriodeListe.map { ResultatPeriode(it) },
        grunnlagListe = grunnlagListe
    )
}

@Schema(description = "Resultatet av en beregning for en gitt periode")
data class ResultatPeriode(
    @Schema(description = "Beregnet resultat periode") var periode: Periode = Periode(),
    @Schema(description = "Beregnet resultat innhold") var resultat: ResultatBeregning = ResultatBeregning(),
    @Schema(description = "Beregnet grunnlag innhold") var grunnlagReferanseListe: List<String> = emptyList()
) {

    constructor(resultatPeriode: ResultatPeriodeCore) : this(
        periode = Periode(resultatPeriode.periode),
        resultat = ResultatBeregning(resultatPeriode.resultat),
        grunnlagReferanseListe = resultatPeriode.grunnlagReferanseListe
    )
}

@Schema(description = "Resultatet av en beregning")
data class ResultatBeregning(
    @Schema(description = "Resultat beløp") var belop: BigDecimal = BigDecimal.ZERO,
    @Schema(description = "Resultat kode") var kode: String = "",
    @Schema(description = "Resultat regel") var regel: String = ""
) {

    constructor(resultatBeregning: ResultatBeregningCore) : this(
        belop = resultatBeregning.belop,
        kode = resultatBeregning.kode,
        regel = resultatBeregning.regel
    )
}

@Schema(description = "Grunnlaget for en beregning")
data class ResultatGrunnlag(
    @Schema(description = "Referanse") val referanse: String = "",
    @Schema(description = "Type") val type: String = "",
    @Schema(description = "Innhold") val innhold: JsonNode = ObjectMapper().createObjectNode()
)
