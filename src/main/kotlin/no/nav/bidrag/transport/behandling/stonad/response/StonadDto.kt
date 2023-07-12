package no.nav.bidrag.transport.behandling.stonad.response

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.Innkreving
import no.nav.bidrag.domain.enums.StonadType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class StonadDto(
    @Schema(description = "StønadId")
    val stonadId: Int,

    @Schema(description = "Stønadstype")
    val type: StonadType,

    @Schema(description = "Referanse til sak")
    val sakId: String,

    @Schema(description = "Id til den som skal betale bidraget")
    val skyldnerId: String,

    @Schema(description = "Id til den som krever bidraget")
    val kravhaverId: String,

    @Schema(description = "Id til den som mottar bidraget")
    val mottakerId: String,

    @Schema(description = "Angir første år en stønad skal indeksreguleres")
    val indeksreguleringAar: String?,

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
    val periodeListe: List<StonadPeriodeDto>
)

data class StonadPeriodeDto(

    @Schema(description = "Periode-id")
    val periodeId: Int,

    @Schema(description = "Periode fra-og-med-dato")
    val periodeFom: LocalDate,

    @Schema(description = "Periode til-dato")
    val periodeTil: LocalDate?,

    @Schema(description = "Stonad-id")
    val stonadId: Int,

    @Schema(description = "Vedtak-id")
    val vedtakId: Int,

    @Schema(description = "Perioden er gyldig fra angitt tidspunkt (vedtakstidspunkt)")
    val gyldigFra: LocalDateTime,

    @Schema(description = "Angir tidspunkt perioden eventuelt er ugyldig fra (tidspunkt for vedtak med periode som erstattet denne)")
    val gyldigTil: LocalDateTime?,

    @Schema(description = "Periode-gjort-ugyldig-av-vedtak-id")
    val periodeGjortUgyldigAvVedtakId: Int?,

    @Schema(description = "Beregnet stønadsbeløp")
    val belop: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
    val valutakode: String?,

    @Schema(description = "Resultatkode for stønaden")
    val resultatkode: String
)
