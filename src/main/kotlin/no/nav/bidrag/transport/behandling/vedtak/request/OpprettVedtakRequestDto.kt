package no.nav.bidrag.transport.behandling.vedtak.request

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import no.nav.bidrag.domain.enums.BehandlingsrefKilde
import no.nav.bidrag.domain.enums.EngangsbeløpType
import no.nav.bidrag.domain.enums.GrunnlagType
import no.nav.bidrag.domain.enums.Innkreving
import no.nav.bidrag.domain.enums.StønadType
import no.nav.bidrag.domain.enums.VedtakKilde
import no.nav.bidrag.domain.enums.VedtakType
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.string.Enhetsnummer
import no.nav.bidrag.domain.string.Landkode
import no.nav.bidrag.domain.string.Saksnummer
import no.nav.bidrag.domain.string.Valutakode
import no.nav.bidrag.domain.tid.PeriodeFom
import no.nav.bidrag.domain.tid.PeriodeTil
import no.nav.bidrag.domain.tid.Vedtakstidspunkt
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

    @Schema(description = "Saksbehandlers navn eller navn på applikasjon ved batchkjøring")
    val opprettetAvNavn: String?,

    @Schema(description = "Tidspunkt/timestamp når vedtaket er fattet")
    val vedtakstidspunkt: Vedtakstidspunkt,

    @Schema(description = "Enheten som er ansvarlig for vedtaket")
    @NotBlank
    val enhetsnummer: Enhetsnummer,

    @Schema(description = "Settes hvis overføring til Elin skal utsettes")
    val innkrevingUtsattTilDato: LocalDate?,

    @Schema(description = "Settes hvis vedtaket er fastsatt i utlandet")
    val fastsattILand: Landkode?,

    @Schema(description = "Liste over alle grunnlag som inngår i vedtaket")
    @field:Valid
    val grunnlagListe: List<OpprettGrunnlagRequestDto>,

    @Schema(description = "Liste over alle stønadsendringer som inngår i vedtaket")
    @field:Valid
    val stønadsendringListe: List<OpprettStønadsendringRequestDto>?,

    @Schema(description = "Liste over alle engangsbeløp som inngår i vedtaket")
    @field:Valid
    val engangsbeløpListe: List<OpprettEngangsbeløpRequestDto>?,

    @Schema(description = "Liste med referanser til alle behandlinger som ligger som grunnlag til vedtaket")
    @field:Valid
    val behandlingsreferanseListe: List<OpprettBehandlingsreferanseRequestDto>?,
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
    val innhold: JsonNode,
)

@Schema
data class OpprettStønadsendringRequestDto(

    @Schema(description = "Stønadstype")
    @NotBlank
    val type: StønadType,

    @Schema(description = "Referanse til sak")
    val sak: Saksnummer,

    @Schema(description = "Personidenten til den som skal betale bidraget")
    val skyldner: PersonIdent,

    @Schema(description = "Personidenten til den som krever bidraget")
    val kravhaver: PersonIdent,

    @Schema(description = "Personidenten til den som mottar bidraget")
    val mottaker: PersonIdent,

    @Schema(description = "Angir første år en stønad skal indeksreguleres")
    val førsteIndeksreguleringsår: Int?,

    @Schema(description = "Angir om stønaden skal innkreves")
    val innkreving: Innkreving,

    @Schema(description = "Angir om en stønad skal endres som følge av vedtaket")
    val endring: Boolean,

    @Schema(description = "Id for vedtaket det er klaget på")
    val omgjørVedtakId: Int?,

    @Schema(description = "Referanse som brukes i utlandssaker")
    val eksternReferanse: String?,

    @Schema(description = "Liste over alle perioder som inngår i stønadsendringen")
    @field:Valid
    val periodeListe: List<OpprettVedtakPeriodeRequestDto>,
)

@Schema
data class OpprettEngangsbeløpRequestDto(

    @Schema(description = "Beløpstype. Saertilskudd, gebyr m.m.")
    @NotBlank
    val type: EngangsbeløpType,

    @Schema(description = "Referanse til sak")
    val sak: Saksnummer,

    @Schema(description = "Personidenten til den som skal betale engangsbeløpet")
    val skyldner: PersonIdent,

    @Schema(description = "Personidenten til den som krever engangsbeløpet")
    val kravhaver: PersonIdent,

    @Schema(description = "Personidenten til den som mottar engangsbeløpet")
    val mottaker: PersonIdent,

    @Schema(description = "Beregnet engangsbeløp")
    @Min(0)
    val beløp: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende engangsbeløpet")
    @NotBlank
    val valutakode: Valutakode?,

    @Schema(description = "Resultatkoden tilhørende engangsbeløpet")
    @NotBlank
    val resultatkode: String,

    @Schema(description = "Angir om engangsbeløpet skal innkreves")
    val innkreving: Innkreving,

    @Schema(description = "Angir om et engangsbeløp skal endres som følge av vedtaket")
    val endring: Boolean,

    @Schema(description = "Id for vedtaket det er klaget på. Utgjør sammen med referanse en unik id for et engangsbeløp")
    val omgjørVedtakId: Int?,

    @Schema(description = "Referanse til engangsbeløp, brukes for å kunne omgjøre engangsbeløp senere i et klagevedtak. Unik innenfor et vedtak")
    val referanse: String,

    @Schema(description = "Referanse - delytelsesId/beslutningslinjeId -> bidrag-regnskap. Skal fjernes senere")
    val delytelseId: String?,

    @Schema(description = "Referanse som brukes i utlandssaker")
    val eksternReferanse: String?,

    @Schema(description = "Liste over alle grunnlag som inngår i engangsbeløpet")
    @NotEmpty
    val grunnlagReferanseListe: List<String>,
)

@Schema
data class OpprettBehandlingsreferanseRequestDto(

    @Schema(description = "Kilde/type for en behandlingsreferanse")
    @NotBlank
    val kilde: BehandlingsrefKilde,

    @Schema(description = "Kildesystemets referanse til behandlingen")
    @NotBlank
    val referanse: String,
)

@Schema
data class OpprettVedtakPeriodeRequestDto(

    @Schema(description = "Periode fra-og-med-dato")
    val periodeFom: PeriodeFom,

    @Schema(description = "Periode til-dato")
    val periodeTil: PeriodeTil?,

    @Schema(description = "Beregnet stønadsbeløp")
    @Min(0)
    val beløp: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
    @NotBlank
    val valutakode: Valutakode?,

    @Schema(description = "Resultatkoden tilhørende stønadsbeløpet")
    @NotBlank
    val resultatkode: String,

    @Schema(description = "Referanse - delytelseId/beslutningslinjeId -> bidrag-regnskap. Skal fjernes senere")
    val delytelseId: String?,

    @Schema(description = "Liste over alle grunnlag som inngår i perioden")
    @NotEmpty
    val grunnlagReferanseListe: List<String>,
)
