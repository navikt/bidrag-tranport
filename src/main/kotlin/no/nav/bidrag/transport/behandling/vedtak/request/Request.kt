package no.nav.bidrag.transport.behandling.vedtak.request

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import no.nav.bidrag.behandling.felles.enums.BehandlingsrefKilde
import no.nav.bidrag.behandling.felles.enums.EngangsbelopType
import no.nav.bidrag.behandling.felles.enums.GrunnlagType
import no.nav.bidrag.behandling.felles.enums.Innkreving
import no.nav.bidrag.behandling.felles.enums.StonadType
import no.nav.bidrag.behandling.felles.enums.VedtakKilde
import no.nav.bidrag.behandling.felles.enums.VedtakType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Schema
data class OpprettVedtakRequestDto(

    @Schema(description = "Hva er kilden til vedtaket. Automatisk eller manuelt")
    val kilde: VedtakKilde,

    @Schema(description = "Type vedtak")
    val type: VedtakType,

    @Schema(description = "Id til saksbehandler/batchjobb evt. annet som oppretter vedtaket")
    @Size(min = 5)
    val opprettetAv: String,

    @Schema(description = "Saksbehandlers navn")
    val opprettetAvNavn: String?,

    @Schema(description = "Tidspunkt/timestamp når vedtaket er fattet")
    val vedtakTidspunkt: LocalDateTime,

    @Schema(description = "Id til enheten som er ansvarlig for vedtaket")
    @NotBlank
    val enhetId: String,

    @Schema(description = "Settes hvis overføring til Elin skal utsettes")
    val utsattTilDato: LocalDate?,

    @Schema(description = "Liste over alle grunnlag som inngår i vedtaket")
    @field:Valid
    val grunnlagListe: List<OpprettGrunnlagRequestDto>,

    @Schema(description = "Liste over alle stønadsendringer som inngår i vedtaket")
    @field:Valid
    val stonadsendringListe: List<OpprettStonadsendringRequestDto>?,

    @Schema(description = "Liste over alle engangsbeløp som inngår i vedtaket")
    @field:Valid
    val engangsbelopListe: List<OpprettEngangsbelopRequestDto>?,

    @Schema(description = "Liste med referanser til alle behandlinger som ligger som grunnlag til vedtaket")
    @field:Valid
    val behandlingsreferanseListe: List<OpprettBehandlingsreferanseRequestDto>?
)

@Schema
data class OpprettGrunnlagRequestDto(

    @Schema(description = "Referanse til grunnlaget")
    @NotBlank
    val referanse: String,

    @Schema(description = "Grunnlagstype")
    @NotBlank
    val type: GrunnlagType,

    @Schema(description = "Innholdet i grunnlaget")
    @NotBlank
    val innhold: JsonNode
)

@Schema
data class OpprettStonadsendringRequestDto(

    @Schema(description = "Stønadstype")
    @NotBlank
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

    @Schema(description = "Angir om en stønad skal endres som følge av vedtaket")
    val endring: Boolean,

    @Schema(description = "VedtakId for vedtaket det er klaget på")
    val omgjorVedtakId: Int?,

    @Schema(description = "Referanse som brukes i utlandssaker")
    val eksternReferanse: String?,

    @Schema(description = "Liste over alle perioder som inngår i stønadsendringen")
    @field:Valid
    @field:NotEmpty(message = "Listen kan ikke være null eller tom.")
    val periodeListe: List<OpprettVedtakPeriodeRequestDto>
)

@Schema
data class OpprettEngangsbelopRequestDto(

    @Schema(description = "Beløpstype. Saertilskudd, gebyr m.m.")
    @NotBlank
    val type: EngangsbelopType,

    @Schema(description = "Referanse til sak")
    val sakId: String,

    @Schema(description = "Id til den som skal betale engangsbeløpet")
    val skyldnerId: String,

    @Schema(description = "Id til den som krever engangsbeløpet")
    val kravhaverId: String,

    @Schema(description = "Id til den som mottar engangsbeløpet")
    val mottakerId: String,

    @Schema(description = "Beregnet engangsbeløp")
    @Min(0)
    val belop: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende engangsbeløpet")
    @NotBlank
    val valutakode: String?,

    @Schema(description = "Resultatkoden tilhørende engangsbeløpet")
    @NotBlank
    val resultatkode: String,

    @Schema(description = "Angir om engangsbeløpet skal innkreves")
    val innkreving: Innkreving,

    @Schema(description = "Angir om et engangsbeløp skal endres som følge av vedtaket")
    val endring: Boolean,

    @Schema(description = "VedtakId for vedtaket det er klaget på. Utgjør sammen med referanse en unik id for et engangsbeløp")
    val omgjorVedtakId: Int?,

    @Schema(description = "Referanse, brukes for å kunne omgjøre engangsbeløp senere i et klagevedtak. Unik innenfor et vedtak")
    val referanse: String,

    @Schema(description = "Referanse - delytelsesId/beslutningslinjeId -> bidrag-regnskap. Skal fjernes senere")
    val delytelseId: String?,

    @Schema(description = "Referanse som brukes i utlandssaker")
    val eksternReferanse: String?,

    @Schema(description = "Liste over alle grunnlag som inngår i engangsbeløpet")
    @NotEmpty
    val grunnlagReferanseListe: List<String>
)

@Schema
data class OpprettBehandlingsreferanseRequestDto(

    @Schema(description = "Kilde/type for en behandlingsreferanse")
    @NotBlank
    val kilde: BehandlingsrefKilde,

    @Schema(description = "Kildesystemets referanse til behandlingen")
    @NotBlank
    val referanse: String
)

@Schema
data class OpprettVedtakPeriodeRequestDto(

    @Schema(description = "Periode fra-og-med-dato")
    val fomDato: LocalDate,

    @Schema(description = "Periode til-dato")
    val tilDato: LocalDate?,

    @Schema(description = "Beregnet stønadsbeløp")
    @Min(0)
    val belop: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
    @NotBlank
    val valutakode: String?,

    @Schema(description = "Resultatkoden tilhørende stønadsbeløpet")
    @NotBlank
    val resultatkode: String,

    @Schema(description = "Referanse - delytelsesId/beslutningslinjeId -> bidrag-regnskap. Skal fjernes senere")
    val delytelseId: String?,

    @Schema(description = "Liste over alle grunnlag som inngår i perioden")
    @NotEmpty
    val grunnlagReferanseListe: List<String>
)

@Schema
data class OpprettVedtakPeriodeGrunnlagRequestDto(

    @Schema(description = "Periode-id")
    @Min(0)
    val periodeId: Int,

    @Schema(description = "grunnlag-id")
    @Min(0)
    val grunnlagId: Int
)
