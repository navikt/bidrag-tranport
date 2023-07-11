package no.nav.bidrag.transport.behandling.vedtak.response

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.BehandlingsrefKilde
import no.nav.bidrag.domain.enums.EngangsbelopType
import no.nav.bidrag.domain.enums.GrunnlagType
import no.nav.bidrag.domain.enums.Innkreving
import no.nav.bidrag.domain.enums.StonadType
import no.nav.bidrag.domain.enums.VedtakKilde
import no.nav.bidrag.domain.enums.VedtakType
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

    @Schema(description = "Saksbehandlers navn")
    val opprettetAvNavn: String?,

    @Schema(description = "Tidspunkt/timestamp når vedtaket er fattet")
    val vedtakTidspunkt: LocalDateTime,

    @Schema(description = "Id til enheten som er ansvarlig for vedtaket")
    val enhetId: String,

    @Schema(description = "Settes hvis overføring til Elin skal utsettes")
    val utsattTilDato: LocalDate?,

    @Schema(description = "Tidspunkt vedtaket er fattet")
    val opprettetTidspunkt: LocalDateTime,

    @Schema(description = "Liste over alle grunnlag som inngår i vedtaket")
    val grunnlagListe: List<GrunnlagDto>,

    @Schema(description = "Liste over alle stønadsendringer som inngår i vedtaket")
    val stonadsendringListe: List<StonadsendringDto>,

    @Schema(description = "Liste over alle engangsbeløp som inngår i vedtaket")
    val engangsbelopListe: List<EngangsbelopDto>,

    @Schema(description = "Liste med referanser til alle behandlinger som ligger som grunnlag til vedtaket")
    val behandlingsreferanseListe: List<BehandlingsreferanseDto>
)

@Schema
data class GrunnlagDto(

    @Schema(description = "Referanse til grunnlaget")
    val referanse: String,

    @Schema(description = "Grunnlagstype")
    val type: GrunnlagType,

    @Schema(description = "Innholdet i grunnlaget")
    val innhold: JsonNode
)

@Schema
data class StonadsendringDto(

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

    @Schema(description = "Angir om en stønad skal endres som følge av vedtaket")
    val endring: Boolean,

    @Schema(description = "VedtakId for vedtaket det er klaget på")
    val omgjorVedtakId: Int?,

    @Schema(description = "Referanse som brukes i utlandssaker")
    val eksternReferanse: String?,

    @Schema(description = "Liste over alle perioder som inngår i stønadsendringen")
    val periodeListe: List<VedtakPeriodeDto>
)

@Schema
data class VedtakPeriodeDto(

    @Schema(description = "Periode fra-og-med-dato")
    val fomDato: LocalDate,

    @Schema(description = "Periode til-dato")
    val tilDato: LocalDate?,

    @Schema(description = "Beregnet stønadsbeløp")
    val belop: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
    val valutakode: String?,

    @Schema(description = "Resultatkoden tilhørende  stønadsbeløpet")
    val resultatkode: String,

    @Schema(description = "Referanse - delytelsesId/beslutningslinjeId -> bidrag-regnskap. Skal fjernes senere")
    val delytelseId: String?,

    @Schema(description = "Liste over alle grunnlag som inngår i perioden")
    val grunnlagReferanseListe: List<String>
)

@Schema
data class EngangsbelopDto(

    @Schema(description = "Type Engangsbeløp. Saertilskudd, gebyr m.m.")
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
    val belop: BigDecimal?,

    @Schema(description = "Valutakoden tilhørende engangsbeløpet")
    val valutakode: String?,

    @Schema(description = "Resultatkoden tilhørende engangsbeløpet")
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

    @Schema(description = "Liste over alle grunnlag som inngår i beregningen")
    val grunnlagReferanseListe: List<String>
)

@Schema
data class BehandlingsreferanseDto(

    @Schema(description = "Kilde/type for en behandlingsreferanse")
    val kilde: BehandlingsrefKilde,

    @Schema(description = "Kildesystemets referanse til behandlingen")
    val referanse: String
)
