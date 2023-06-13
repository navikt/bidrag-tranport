package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.Innkreving
import no.nav.bidrag.behandling.felles.enums.StonadType
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

@Schema
data class AlleMottakerIdHistorikkForStonadDto(

    @Schema(description = "Alle forekomster på mottaker-id-historikk for en stønad")
    val alleMottakerIdHistorikkForStonad: List<MottakerIdHistorikkDto>?
)

data class MottakerIdHistorikkDto(

    @Schema(description = "stonad-id")
    val stonadId: Int,

    @Schema(description = "Utgått Mottaker-Id")
    val mottakerIdEndretFra: String,

    @Schema(description = "Ny Mottaker-Id")
    val mottakerIdEndretTil: String,

    @Schema(description = "Saksbehandler/batchjobb/annet som har oppdatert mottaker-id")
    val opprettetAv: String,

    @Schema(description = "Opprettet tidspunkt")
    val opprettetTidspunkt: LocalDateTime
)
