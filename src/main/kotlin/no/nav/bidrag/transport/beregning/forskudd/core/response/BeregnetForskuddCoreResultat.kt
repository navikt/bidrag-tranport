package no.nav.bidrag.transport.beregning.forskudd.core.response

import no.nav.bidrag.domain.enums.resultatkoder.ResultatKodeForskudd
import no.nav.bidrag.transport.beregning.felles.AvvikCore
import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonResultatGrunnlagCore
import java.math.BigDecimal

// Resultat
data class BeregnetForskuddResultatCore(
    val beregnetForskuddPeriodeListe: List<ResultatPeriodeCore>,
    val sjablonListe: List<SjablonResultatGrunnlagCore>,
    val avvikListe: List<AvvikCore>
)

data class ResultatPeriodeCore(
    val periode: PeriodeCore,
    val resultat: ResultatBeregningCore,
    val grunnlagReferanseListe: List<String>
)

data class ResultatBeregningCore(
    val belop: BigDecimal,
    val kode: ResultatKodeForskudd,
    val regel: String
)
