package no.nav.bidrag.transport.beregning.barnebidrag.core.response

import no.nav.bidrag.transport.beregning.felles.AvvikCore
import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonResultatGrunnlagCore
import java.math.BigDecimal

// Resultat
data class BeregnetBarnebidragResultatCore(
    val resultatPeriodeListe: List<ResultatPeriodeCore>,
    val sjablonListe: List<SjablonResultatGrunnlagCore>,
    val avvikListe: List<AvvikCore>
)

data class ResultatPeriodeCore(
    val soknadsbarnPersonId: Int,
    val periode: PeriodeCore,
    val resultat: ResultatBeregningCore,
    val grunnlagReferanseListe: List<String>
)

data class ResultatBeregningCore(
    val belop: BigDecimal,
    val kode: String
)
