package no.nav.bidrag.transport.beregning.saertilskudd.core.request

import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonPeriodeCore
import java.math.BigDecimal
import java.time.LocalDate

// Grunnlag periode
data class BeregnBPsAndelSaertilskuddGrunnlagCore(
    val beregnDatoFra: LocalDate,
    val beregnDatoTil: LocalDate,
    val nettoSaertilskuddPeriodeListe: List<NettoSaertilskuddPeriodeCore>,
    val inntektBPPeriodeListe: List<BPASInntektPeriodeCore>,
    val inntektBMPeriodeListe: List<BPASInntektPeriodeCore>,
    val inntektBBPeriodeListe: List<BPASInntektPeriodeCore>,
    var sjablonPeriodeListe: List<SjablonPeriodeCore>
)

data class NettoSaertilskuddPeriodeCore(
    val referanse: String,
    val periodeDatoFraTil: PeriodeCore,
    val nettoSaertilskuddBelop: BigDecimal
)

data class BPASInntektPeriodeCore(
    val referanse: String,
    val periodeDatoFraTil: PeriodeCore,
    val inntektType: String,
    val inntektBelop: BigDecimal,
    val deltFordel: Boolean,
    val skatteklasse2: Boolean
)
