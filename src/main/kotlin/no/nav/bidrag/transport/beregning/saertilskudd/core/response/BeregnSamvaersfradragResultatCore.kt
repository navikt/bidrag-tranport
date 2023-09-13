package no.nav.bidrag.transport.beregning.saertilskudd.core.response

import no.nav.bidrag.transport.beregning.felles.AvvikCore
import no.nav.bidrag.transport.beregning.felles.IResultatPeriode
import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonResultatGrunnlagCore
import java.math.BigDecimal

// Resultatperiode
data class BeregnSamvaersfradragResultatCore(
    val resultatPeriodeListe: List<SamvaersfradragResultatPeriodeCore>,
    val sjablonListe: List<SjablonResultatGrunnlagCore>,
    val avvikListe: List<AvvikCore>
)

data class SamvaersfradragResultatPeriodeCore(
    override val periode: PeriodeCore,
    val resultatBeregningListe: List<SamvaersfradragResultatBeregningCore>,
    override val grunnlagReferanseListe: List<String>
) : IResultatPeriode

data class SamvaersfradragResultatBeregningCore(
    val barnPersonId: Int,
    val belop: BigDecimal
)
