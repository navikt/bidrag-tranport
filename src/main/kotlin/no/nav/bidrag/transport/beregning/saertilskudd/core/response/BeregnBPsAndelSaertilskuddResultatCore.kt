package no.nav.bidrag.transport.beregning.saertilskudd.core.response

import no.nav.bidrag.domain.enums.InntektType
import no.nav.bidrag.transport.beregning.felles.AvvikCore
import no.nav.bidrag.transport.beregning.felles.IResultatPeriode
import no.nav.bidrag.transport.beregning.felles.PeriodeCore
import no.nav.bidrag.transport.beregning.felles.SjablonResultatGrunnlagCore
import java.math.BigDecimal

// Resultatperiode
data class BeregnBPsAndelSaertilskuddResultatCore(
    val resultatPeriodeListe: List<BPASResultatPeriodeCore>,
    val sjablonListe: List<SjablonResultatGrunnlagCore>,
    val avvikListe: List<AvvikCore>
)

data class BPASResultatPeriodeCore(
    override val periode: PeriodeCore,
    val resultatBeregning: BPASResultatBeregningCore,
    val beregnedeGrunnlag: BPASBeregnedeGrunnlagCore,
    override val grunnlagReferanseListe: List<String>
) : IResultatPeriode

data class BPASResultatBeregningCore(
    val resultatAndelProsent: BigDecimal,
    val resultatAndelBelop: BigDecimal,
    val barnetErSelvforsorget: Boolean
)

data class BPASBeregnedeGrunnlagCore(
    val inntektBPListe: List<BPASInntektCore>,
    val inntektBMListe: List<BPASInntektCore>,
    val inntektBBListe: List<BPASInntektCore>
)

data class BPASInntektCore(
    val referanse: String,
    val inntektType: InntektType,
    val inntektBelop: BigDecimal,
    val deltFordel: Boolean,
    val skatteklasse2: Boolean
)
