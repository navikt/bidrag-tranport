package no.nav.bidrag.transport.beregning.barnebidrag.core.request

import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonPeriodeCore
import java.math.BigDecimal
import java.time.LocalDate

// Grunnlag
data class BeregnBarnebidragGrunnlagCore(
  val beregnDatoFra: LocalDate,
  val beregnDatoTil: LocalDate,
  val bidragsevnePeriodeListe: List<BidragsevnePeriodeCore>,
  val bPsAndelUnderholdskostnadPeriodeListe: List<BPsAndelUnderholdskostnadPeriodeCore>,
  val samvaersfradragPeriodeListe: List<SamvaersfradragPeriodeCore>,
  val deltBostedPeriodeListe: List<DeltBostedPeriodeCore>,
  val barnetilleggBPPeriodeListe: List<BarnetilleggPeriodeCore>,
  val barnetilleggBMPeriodeListe: List<BarnetilleggPeriodeCore>,
  val barnetilleggForsvaretPeriodeListe: List<BarnetilleggForsvaretPeriodeCore>,
  val andreLopendeBidragPeriodeListe: List<AndreLopendeBidragPeriodeCore>,
  val sjablonPeriodeListe: List<SjablonPeriodeCore>
)

data class BidragsevnePeriodeCore(
  val referanse: String,
  val periode: PeriodeCore,
  val belop: BigDecimal,
  val tjuefemProsentInntekt: BigDecimal
)

data class BPsAndelUnderholdskostnadPeriodeCore(
  val referanse: String,
  val soknadsbarnPersonId: Int,
  val periode: PeriodeCore,
  val andelProsent: BigDecimal,
  val andelBelop: BigDecimal,
  val barnetErSelvforsorget: Boolean
)

data class SamvaersfradragPeriodeCore(
  val referanse: String,
  val soknadsbarnPersonId: Int,
  val periode: PeriodeCore,
  val belop: BigDecimal
)

data class DeltBostedPeriodeCore(
  val referanse: String,
  val soknadsbarnPersonId: Int,
  val periode: PeriodeCore,
  val deltBostedIPeriode: Boolean
)

data class BarnetilleggPeriodeCore(
  val referanse: String,
  val soknadsbarnPersonId: Int,
  val periode: PeriodeCore,
  val belop: BigDecimal,
  val skattProsent: BigDecimal
)

data class BarnetilleggForsvaretPeriodeCore(
  val referanse: String,
  val periode: PeriodeCore,
  val barnetilleggForsvaretIPeriode: Boolean
)

data class AndreLopendeBidragPeriodeCore(
  val referanse: String,
  val periode: PeriodeCore,
  val barnPersonId: Int,
  val bidragBelop: BigDecimal,
  val samvaersfradragBelop: BigDecimal
)