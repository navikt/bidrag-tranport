package no.nav.bidrag.transport.beregning.saertilskudd.rest.response

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.transport.beregning.felles.Periode
import no.nav.bidrag.transport.beregning.saertilskudd.core.response.BeregnSaertilskuddResultatCore
import no.nav.bidrag.transport.beregning.saertilskudd.core.response.ResultatBeregningCore
import no.nav.bidrag.transport.beregning.saertilskudd.core.response.ResultatPeriodeCore
import no.nav.bidrag.transport.beregning.saertilskudd.rest.request.Grunnlag
import java.math.BigDecimal

data class BeregnetTotalSaertilskuddResultat(
  @Schema(description = "Periodisert liste over resultat av barnebidragsberegning") var beregnetSaertilskuddPeriodeListe: List<ResultatPeriode> = emptyList(),
  @Schema(description = "Liste over grunnlag brukt i beregning") var grunnlagListe: List<Grunnlag> = emptyList()
) {

  constructor(beregnetSaertilskuddResultatCore: BeregnSaertilskuddResultatCore, grunnlagListe: List<Grunnlag>) : this(
    beregnetSaertilskuddPeriodeListe = beregnetSaertilskuddResultatCore.resultatPeriodeListe.map { ResultatPeriode(it) },
    grunnlagListe = grunnlagListe
  )
}

@Schema(description = "Resultatet av en beregning for en gitt periode")
data class ResultatPeriode(
  @Schema(description = "Søknadsbarn") var barn: Int = 0,
  @Schema(description = "Beregnet resultat periode") var periode: Periode = Periode(),
  @Schema(description = "Beregnet resultat innhold") var resultat: ResultatBeregning = ResultatBeregning(),
  @Schema(description = "Beregnet grunnlag innhold") var grunnlagReferanseListe: List<String> = emptyList()
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
  @Schema(description = "Resultat beløp") var belop: BigDecimal = BigDecimal.ZERO,
  @Schema(description = "Resultat kode") var kode: String = ""
) {

  constructor(resultatBeregning: ResultatBeregningCore) : this(
    belop = resultatBeregning.belop,
    kode = resultatBeregning.kode
  )
}