

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.resultatkoder.ResultatKodeBarnebidrag
import no.nav.bidrag.transport.beregning.barnebidrag.core.response.BeregnetBarnebidragResultatCore
import no.nav.bidrag.transport.beregning.barnebidrag.core.response.ResultatBeregningCore
import no.nav.bidrag.transport.beregning.barnebidrag.core.response.ResultatPeriodeCore
import no.nav.bidrag.transport.beregning.felles.Grunnlag
import no.nav.bidrag.transport.beregning.felles.Periode
import java.math.BigDecimal

// Barnebidrag
@Schema(description = "Resultatet av en barnebidragsberegning")
data class BeregnetTotalBarnebidragResultat(
    @Schema(description = "Periodisert liste over resultat av barnebidragsberegning") var beregnetBarnebidragPeriodeListe: List<ResultatPeriode> = emptyList(),
    @Schema(description = "Liste over grunnlag brukt i beregning") var grunnlagListe: List<Grunnlag> = emptyList()
) {

    constructor(beregnetBarnebidragResultat: BeregnetBarnebidragResultatCore, grunnlagListe: List<Grunnlag>) : this(
        beregnetBarnebidragPeriodeListe = beregnetBarnebidragResultat.resultatPeriodeListe.map { ResultatPeriode(it) },
        grunnlagListe = grunnlagListe
    )
}

@Schema(description = "Resultatet av en beregning for en gitt periode - barnebidrag")
data class ResultatPeriode(
    @Schema(description = "Søknadsbarn") var barn: Int = 0,
    @Schema(description = "Beregnet resultat periode") var periode: Periode,
    @Schema(description = "Beregnet resultat innhold") var resultat: ResultatBeregning,
    @Schema(description = "Beregnet grunnlag innhold") var grunnlagReferanseListe: List<String>
) {

    constructor(resultatPeriode: ResultatPeriodeCore) : this(
        barn = resultatPeriode.soknadsbarnPersonId,
        periode = Periode(resultatPeriode.periode),
        resultat = ResultatBeregning(resultatPeriode.resultat),
        grunnlagReferanseListe = resultatPeriode.grunnlagReferanseListe
    )
}

@Schema(description = "Resultatet av en beregning")
data class ResultatBeregning(
    @Schema(description = "Resultat beløp") var belop: BigDecimal,
    @Schema(description = "Resultat kode") var kode: ResultatKodeBarnebidrag
) {

    constructor(resultatBeregning: ResultatBeregningCore) : this(
        belop = resultatBeregning.belop,
        kode = resultatBeregning.kode
    )
}
