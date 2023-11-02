package no.nav.bidrag.transport.behandling.stonad.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.Innkrevingstype
import no.nav.bidrag.domene.enums.Stønadstype
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.streng.Saksnummer
import no.nav.bidrag.domene.tid.ÅrMånedsperiode
import java.math.BigDecimal
import java.time.LocalDateTime

@Schema(description = "Egenskaper ved en stønadsendring")
data class OpprettStønadRequestDto(

    @Schema(description = "Stønadstype")
    val type: Stønadstype,

    @Schema(description = "Referanse til sak")
    val sak: Saksnummer,

    @Schema(description = "Personidenten til den som skal betale bidraget")
    val skyldner: Personident,

    @Schema(description = "Personidenten til den som krever bidraget")
    val kravhaver: Personident,

    @Schema(description = "Personidenten til den som mottar bidraget")
    val mottaker: Personident,

    @Schema(description = "Angir første år en stønad skal indeksreguleres")
    val førsteIndeksreguleringsår: Int?,

    @Schema(description = "Angir om stønaden skal innkreves")
    val innkreving: Innkrevingstype,

    @Schema(description = "opprettet_av")
    val opprettetAv: String,

    @Schema(description = "Liste over alle perioder som inngår i stønaden")
    val periodeListe: List<OpprettStønadsperiodeRequestDto>,
)

@Schema(description = "Egenskaper ved en periode")
data class OpprettStønadsperiodeRequestDto(

    @Schema(description = "Periode med Fra-og-med-dato og til-dato med format ÅÅÅÅ-MM")
    val periode: ÅrMånedsperiode,

    @Schema(description = "Vedtaksid")
    val vedtaksid: Int,

    @Schema(description = "Perioden er gyldig fra angitt tidspunkt (vedtakstidspunkt)")
    val gyldigFra: LocalDateTime,

    @Schema(description = "Angir tidspunkt perioden eventuelt er ugyldig fra (tidspunkt for vedtak med periode som erstattet denne)")
    val gyldigTil: LocalDateTime?,

    @Schema(description = "Periode gjort ugyldig av vedtak-id")
    val periodeGjortUgyldigAvVedtaksid: Int?,

    @Schema(description = "Beregnet stønadsbeløp")
    val beløp: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
    val valutakode: String?,

    @Schema(description = "Resultatkoden tilhørende stønadsbeløpet")
    val resultatkode: String,

)
