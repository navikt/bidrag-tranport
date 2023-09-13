package no.nav.bidrag.transport.beregning.saertilskudd.core.request

import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonPeriodeCore
import java.time.LocalDate

data class BeregnSamvaersfradragGrunnlagCore(
    val beregnDatoFra: LocalDate,
    val beregnDatoTil: LocalDate,
    val samvaersklassePeriodeListe: List<SamvaersklassePeriodeCore>,
    var sjablonPeriodeListe: List<SjablonPeriodeCore>
)

data class SamvaersklassePeriodeCore(
    val referanse: String,
    val samvaersklassePeriodeDatoFraTil: PeriodeCore,
    val barnPersonId: Int,
    val barnFodselsdato: LocalDate,
    val samvaersklasse: String
)
