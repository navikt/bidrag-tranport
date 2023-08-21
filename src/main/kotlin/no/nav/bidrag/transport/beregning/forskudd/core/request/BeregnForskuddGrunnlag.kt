package no.nav.bidrag.transport.beregning.forskudd.core.request

import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonPeriodeCore
import java.math.BigDecimal
import java.time.LocalDate

// Grunnlag
data class BeregnForskuddGrunnlagCore(
    val beregnDatoFra: LocalDate,
    val beregnDatoTil: LocalDate,
    val soknadBarn: SoknadBarnCore,
    val bostatusPeriodeListe: List<BostatusPeriodeCore>,
    val inntektPeriodeListe: List<InntektPeriodeCore>,
    val sivilstandPeriodeListe: List<SivilstandPeriodeCore>,
    val barnIHusstandenPeriodeListe: List<BarnIHusstandenPeriodeCore>,
    var sjablonPeriodeListe: List<SjablonPeriodeCore>
)

data class SoknadBarnCore(
    val referanse: String,
    val fodselsdato: LocalDate
)

data class BostatusPeriodeCore(
    val referanse: String,
    val periode: PeriodeCore,
    val kode: String
)

data class InntektPeriodeCore(
    val referanse: String,
    val periode: PeriodeCore,
    val type: String,
    val belop: BigDecimal
)

data class SivilstandPeriodeCore(
    val referanse: String,
    val periode: PeriodeCore,
    val kode: String
)

data class BarnIHusstandenPeriodeCore(
    val referanse: String,
    val periode: PeriodeCore,
    val antall: Double
)