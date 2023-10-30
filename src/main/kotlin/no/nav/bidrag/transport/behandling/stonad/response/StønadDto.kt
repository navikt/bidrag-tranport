package no.nav.bidrag.transport.behandling.stonad.response

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.Innkreving
import no.nav.bidrag.domain.enums.StønadType
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.string.Saksnummer
import no.nav.bidrag.domain.string.Valutakode
import no.nav.bidrag.domain.tid.Periode
import no.nav.bidrag.domain.tid.PeriodeTil
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class StønadDto(
    @Schema(description = "Stønadsid")
    val stønadsid: Int,

    @Schema(description = "Stønadstype")
    val type: StønadType,

    @Schema(description = "Referanse til sak")
    val sak: Saksnummer,

    @Schema(description = "Id til den som skal betale bidraget")
    val skyldner: PersonIdent,

    @Schema(description = "Id til den som krever bidraget")
    val kravhaver: PersonIdent,

    @Schema(description = "Id til den som mottar bidraget")
    val mottaker: PersonIdent,

    @Schema(description = "Angir første år en stønad skal indeksreguleres")
    val førsteIndeksreguleringsår: Int?,

    @Schema(description = "Angir om stønaden skal innkreves")
    val innkreving: Innkreving,

    @Schema(description = "opprettet_av")
    val opprettetAv: String,

    @Schema(description = "opprettet tidspunkt")
    val opprettetTidspunkt: LocalDateTime,

    @Schema(description = "endret av")
    val endretAv: String?,

    @Schema(description = "når sist endret tidspunkt")
    val endretTidspunkt: LocalDateTime?,

    @Schema(description = "Liste over alle perioder som inngår i stønaden")
    val periodeListe: List<StønadPeriodeDto>,
)

data class StønadPeriodeDto(

    @Schema(description = "Periodeid")
    val periodeid: Int,

    @Schema(description = "Periode fra-og-med-dato")
    val fom: Periode<LocalDate>,

    @Schema(description = "Periode til-dato")
    val til: Periode<LocalDate>?,

    @Schema(description = "Stønadsid")
    val stønadsid: Int,

    @Schema(description = "Vedtaksid")
    val vedtaksid: Int,

    @Schema(description = "Perioden er gyldig fra angitt tidspunkt (vedtakstidspunkt)")
    val gyldigFra: LocalDateTime,

    @Schema(description = "Angir tidspunkt perioden eventuelt er ugyldig fra (tidspunkt for vedtak med periode som erstattet denne)")
    val gyldigTil: LocalDateTime?,

    @Schema(description = "Periode-gjort-ugyldig-av-vedtaksid")
    val periodeGjortUgyldigAvVedtaksid: Int?,

    @Schema(description = "Beregnet stønadsbeløp")
    val beløp: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
    val valutakode: Valutakode?,

    @Schema(description = "Resultatkode for stønaden")
    val resultatkode: String,
)
