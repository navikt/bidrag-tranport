package no.nav.bidrag.transport.beregning.saertilskudd.core.response

import no.nav.bidrag.transport.beregning.felles.AvvikCore
import no.nav.bidrag.transport.beregning.felles.IResultatPeriode
import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonResultatGrunnlagCore
import java.math.BigDecimal

// Resultatperiode
data class BeregnBidragsevneResultatCore(
    val resultatPeriodeListe: List<BidragsevneResultatPeriodeCore>,
    val sjablonListe: List<SjablonResultatGrunnlagCore>,
    val avvikListe: List<AvvikCore>
)

data class BidragsevneResultatPeriodeCore(
    override val periode: PeriodeCore,
    val resultatBeregning: BidragsevneResultatBeregningCore,
    override val grunnlagReferanseListe: List<String>
) : IResultatPeriode

data class BidragsevneResultatBeregningCore(
    val belop: BigDecimal
)
