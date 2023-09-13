package no.nav.bidrag.transport.beregning.saertilskudd.core.request

import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonPeriodeCore
import java.math.BigDecimal
import java.time.LocalDate

// Grunnlag periode
data class BeregnBidragsevneGrunnlagCore(
    val beregnDatoFra: LocalDate,
    val beregnDatoTil: LocalDate,
    val inntektPeriodeListe: List<InntektPeriodeCore>,
    val skatteklassePeriodeListe: List<SkatteklassePeriodeCore>,
    val bostatusPeriodeListe: List<BostatusPeriodeCore>,
    val antallBarnIEgetHusholdPeriodeListe: List<AntallBarnIEgetHusholdPeriodeCore>,
    val saerfradragPeriodeListe: List<SaerfradragPeriodeCore>,
    var sjablonPeriodeListe: List<SjablonPeriodeCore>
)

data class InntektPeriodeCore(
    val referanse: String,
    val periodeDatoFraTil: PeriodeCore,
    val inntektType: String,
    val inntektBelop: BigDecimal
)

data class SkatteklassePeriodeCore(
    val referanse: String,
    val periodeDatoFraTil: PeriodeCore,
    val skatteklasse: Int
)

data class BostatusPeriodeCore(
    val referanse: String,
    val periodeDatoFraTil: PeriodeCore,
    val bostatusKode: String
)

data class AntallBarnIEgetHusholdPeriodeCore(
    val referanse: String,
    val periodeDatoFraTil: PeriodeCore,
    val antallBarn: Double
)

data class SaerfradragPeriodeCore(
    val referanse: String,
    val periodeDatoFraTil: PeriodeCore,
    val saerfradragKode: String
)
