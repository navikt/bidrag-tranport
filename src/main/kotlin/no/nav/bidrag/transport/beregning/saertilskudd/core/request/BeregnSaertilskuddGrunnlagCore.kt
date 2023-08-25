package no.nav.bidrag.transport.beregning.saertilskudd.core.request

import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonPeriodeCore
import java.math.BigDecimal
import java.time.LocalDate

// Grunnlag periode
data class BeregnSaertilskuddGrunnlagCore(
  val beregnDatoFra: LocalDate,
  val beregnDatoTil: LocalDate,
  val soknadsbarnPersonId: Int,
  val bidragsevnePeriodeListe: List<BidragsevnePeriodeCore>,
  val bPsAndelSaertilskuddPeriodeListe: List<BPsAndelSaertilskuddPeriodeCore>,
  val lopendeBidragPeriodeListe: List<LopendeBidragPeriodeCore>,
  val samvaersfradragPeriodeListe: List<SamvaersfradragPeriodeCore>,
  val sjablonPeriodeListe: List<SjablonPeriodeCore>
)

data class BidragsevnePeriodeCore(
  val referanse: String,
  val periodeDatoFraTil: PeriodeCore,
  val bidragsevneBelop: BigDecimal
)

data class BPsAndelSaertilskuddPeriodeCore(
  val referanse: String,
  val periodeDatoFraTil: PeriodeCore,
  val bPsAndelSaertilskuddProsent: BigDecimal,
  val bPsAndelSaertilskuddBelop: BigDecimal,
  val barnetErSelvforsorget: Boolean
)

data class LopendeBidragPeriodeCore(
  val referanse: String,
  val periodeDatoFraTil: PeriodeCore,
  val barnPersonId: Int,
  val lopendeBidragBelop: BigDecimal,
  val opprinneligBPsAndelUnderholdskostnadBelop: BigDecimal,
  val opprinneligBidragBelop: BigDecimal,
  val opprinneligSamvaersfradragBelop: BigDecimal
)

data class SamvaersfradragPeriodeCore(
  val referanse: String,
  val periodeDatoFraTil: PeriodeCore,
  val barnPersonId: Int,
  val samvaersfradragBelop: BigDecimal
)
