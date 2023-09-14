package no.nav.bidrag.transport.beregning.saertilskudd.core.response

import no.nav.bidrag.domain.enums.resultatkoder.ResultatKodeSaertilskudd
import no.nav.bidrag.transport.beregning.felles.AvvikCore
import no.nav.bidrag.transport.beregning.felles.IResultatPeriode
import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import java.math.BigDecimal

// Resultatperiode
data class BeregnSaertilskuddResultatCore(
    val resultatPeriodeListe: List<SaertilskuddResultatPeriodeCore>,
    val avvikListe: List<AvvikCore>
)

data class SaertilskuddResultatPeriodeCore(
    override val periode: PeriodeCore,
    val soknadsbarnPersonId: Int,
    val resultatBeregning: SaertilskuddResultatBeregningCore,
    override val grunnlagReferanseListe: List<String>
) : IResultatPeriode

data class SaertilskuddResultatBeregningCore(
    val belop: BigDecimal,
    val kode: ResultatKodeSaertilskudd
)
