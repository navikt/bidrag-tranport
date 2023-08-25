package no.nav.bidrag.transport.beregning.saertilskudd.core.response

import no.nav.bidrag.transport.beregning.felles.AvvikCore
import no.nav.bidrag.transport.beregning.felles.IResultatPeriode
import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import java.math.BigDecimal

// Resultatperiode
data class BeregnSaertilskuddResultatCore(
  val resultatPeriodeListe: List<ResultatPeriodeCore>,
  val avvikListe: List<AvvikCore>
)

data class ResultatPeriodeCore(
  override val periode: PeriodeCore,
  val soknadsbarnPersonId: Int,
  val resultat: ResultatBeregningCore,
  override val grunnlagReferanseListe: List<String>
) : IResultatPeriode

data class ResultatBeregningCore(
  val belop: BigDecimal,
  val kode: String,
)