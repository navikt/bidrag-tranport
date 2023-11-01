package no.nav.bidrag.transport.behandling.vedtak.response

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import no.nav.bidrag.domene.enums.BehandlingsrefKilde
import no.nav.bidrag.domene.enums.EngangsbeløpType
import no.nav.bidrag.domene.enums.GrunnlagType
import no.nav.bidrag.domene.enums.Innkreving
import no.nav.bidrag.domene.enums.StønadType
import no.nav.bidrag.domene.enums.VedtakKilde
import no.nav.bidrag.domene.enums.VedtakType
import no.nav.bidrag.domene.ident.PersonIdent
import no.nav.bidrag.domene.streng.Enhetsnummer
import no.nav.bidrag.domene.streng.Saksnummer
import no.nav.bidrag.domene.tid.Datoperiode
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Schema
data class VedtakDto(

    @Schema(description = "Hva er kilden til vedtaket. Automatisk eller manuelt")
    val kilde: VedtakKilde,

    @Schema(description = "Type vedtak")
    val type: VedtakType,

    @Schema(description = "Id til saksbehandler/batchjobb evt annet som opprettet vedtaket")
    val opprettetAv: String,

    @Schema(description = "Saksbehandlers navn eller navn på applikasjon ved batchkjøring")
    val opprettetAvNavn: String?,

    @Schema(description = "Tidspunkt/timestamp når vedtaket er fattet")
    val vedtakstidspunkt: LocalDateTime,

    @Schema(description = "Enheten som er ansvarlig for vedtaket")
    val enhetsnummer: Enhetsnummer,

    @Schema(description = "Settes hvis overføring til Elin skal utsettes")
    val innkrevingUtsattTilDato: LocalDate?,

    @Schema(description = "Settes hvis vedtaket er fastsatt i utlandet")
    val fastsattILand: String?,

    @Schema(description = "Tidspunkt vedtaket er fattet")
    val opprettetTidspunkt: LocalDateTime,

    @Schema(description = "Liste over alle grunnlag som inngår i vedtaket")
    val grunnlagListe: List<GrunnlagDto>,

    @Schema(description = "Liste over alle stønadsendringer som inngår i vedtaket")
    val stønadsendringListe: List<StønadsendringDto>,

    @Schema(description = "Liste over alle engangsbeløp som inngår i vedtaket")
    val engangsbeløpListe: List<EngangsbeløpDto>,

    @Schema(description = "Liste med referanser til alle behandlinger som ligger som grunnlag til vedtaket")
    val behandlingsreferanseListe: List<BehandlingsreferanseDto>,
)

@Schema
data class GrunnlagDto(

    @Schema(description = "Referanse til grunnlaget")
    val referanse: String,

    @Schema(description = "Grunnlagstype")
    val type: GrunnlagType,

    @Schema(description = "Innholdet i grunnlaget")
    val innhold: JsonNode,
)

@Schema
data class StønadsendringDto(

    @Schema(description = "Stønadstype")
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

    @Schema(description = "Liste over grunnlag som er knyttet direkte til stønadsendringen")
    val grunnlagReferanseListe: List<String>,

    @Schema(description = "Liste over alle perioder som inngår i stønadsendringen")
    val periodeListe: List<VedtakPeriodeDto>,
)

@Schema
data class VedtakPeriodeDto(

    @Schema(description = "Periode med fra-og-med-dato og til-dato med format ÅÅÅÅ-MM-DD")
    val periode: Datoperiode,

    @Schema(description = "Beregnet stønadsbeløp")
    @Min(0)
    val beløp: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
    val valutakode: String?,

    @Schema(description = "Resultatkoden tilhørende stønadsbeløpet")
    val resultatkode: String,

    @Schema(description = "Referanse - delytelseId/beslutningslinjeId -> bidrag-regnskap. Skal fjernes senere")
    val delytelseId: String?,

    @Schema(description = "Liste over alle grunnlag som inngår i perioden")
    val grunnlagReferanseListe: List<String>,
)

@Schema
data class EngangsbeløpDto(

    @Schema(description = "Type Engangsbeløp. Saertilskudd, gebyr m.m.")
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
    val valutakode: String?,

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

    @Schema(description = "Liste over alle grunnlag som inngår i beregningen")
    val grunnlagReferanseListe: List<String>,
)

@Schema
data class BehandlingsreferanseDto(

    @Schema(description = "Kilde/type for en behandlingsreferanse")
    val kilde: BehandlingsrefKilde,

    @Schema(description = "Kildesystemets referanse til behandlingen")
    val referanse: String,
)
