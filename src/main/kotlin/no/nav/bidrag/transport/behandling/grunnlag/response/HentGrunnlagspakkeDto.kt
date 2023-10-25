package no.nav.bidrag.transport.behandling.grunnlag.response

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.SivilstandKode
import no.nav.bidrag.domain.enums.barnetilsyn.Skolealder
import no.nav.bidrag.domain.enums.barnetilsyn.Tilsyntype
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class HentGrunnlagspakkeDto(

    @Schema(description = "grunnlagspakke-id")
    val grunnlagspakkeId: Int,

    @Schema(description = "Periodisert liste over innhentede inntekter fra a-inntekt og underliggende poster")
    val ainntektListe: List<AinntektDto>,

    @Schema(description = "Periodisert liste over innhentede fra skatt og underliggende poster")
    val skattegrunnlagListe: List<SkattegrunnlagDto>,

    @Schema(description = "Periodisert liste over innhentet utvidet barnetrygd og småbarnstillegg")
    val ubstListe: List<UtvidetBarnetrygdOgSmaabarnstilleggDto>,

    @Schema(description = "Periodisert liste over innhentet barnetillegg")
    val barnetilleggListe: List<BarnetilleggDto>,

    @Schema(description = "Periodisert liste over innhentet kontantstøtte")
    val kontantstotteListe: List<KontantstotteDto>,

    @Deprecated(message = "Utgått og erstattet av husstandmedlemmerOgEgneBarnListe")
    val egneBarnIHusstandenListe: List<RelatertPersonDto> = emptyList(),

    @Deprecated(message = "Utgått og erstattet av husstandmedlemmerOgEgneBarnListe")
    val husstandmedlemListe: List<RelatertPersonDto> = emptyList(),

    @Schema(
        description = "Liste over alle personer som har bodd sammen med BM/BP i perioden fra virkningstidspunkt og fremover med en liste " +
            "over hvilke perioder de har delt bolig. Listen inkluderer i tillegg personens egne barn, selv om de ikke har delt bolig med BM/BP"
    )
    val husstandmedlemmerOgEgneBarnListe: List<RelatertPersonDto>,

    @Schema(description = "Periodisert liste over en persons sivilstand")
    val sivilstandListe: List<SivilstandDto>,

    @Schema(description = "Periodisert liste over innhentet barnetilsyn")
    val barnetilsynListe: List<BarnetilsynDto>

)

data class AinntektDto(

    @Schema(description = "Id til personen inntekten er rapportert for")
    val personId: String,

    @Schema(description = "Periode fra-dato")
    val periodeFra: LocalDate,

    @Schema(description = "Periode til-dato")
    val periodeTil: LocalDate,

    @Schema(description = "Angir om en inntektsopplysning er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt inntekten taes i bruk")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt inntekten ikke lenger er aktiv som grunnlag. Null betyr at inntekten er aktiv")
    val brukTil: LocalDateTime?,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime,

    @Schema(description = "Liste over poster for innhentede inntektsposter")
    val ainntektspostListe: List<AinntektspostDto>
)

data class AinntektspostDto(

    @Schema(description = "Perioden innteksposten er utbetalt YYYYMM")
    val utbetalingsperiode: String?,

    @Schema(description = "Fra-dato for opptjening")
    val opptjeningsperiodeFra: LocalDate?,

    @Schema(description = "Til-dato for opptjening")
    val opptjeningsperiodeTil: LocalDate?,

    @Schema(description = "Id til de som rapporterer inn inntekten")
    val opplysningspliktigId: String?,

    @Schema(description = "Id til virksomheten som rapporterer inn inntekten")
    val virksomhetId: String?,

    @Schema(description = "Type inntekt, Lonnsinntekt, Naeringsinntekt, Pensjon eller trygd, Ytelse fra offentlig")
    val inntektType: String,

    @Schema(description = "Type fordel, Kontantytelse, Naturalytelse, Utgiftsgodtgjorelse")
    val fordelType: String?,

    @Schema(description = "Beskrivelse av inntekt")
    val beskrivelse: String?,

    @Schema(description = "Belop")
    val belop: BigDecimal,

    @Schema(description = "Fra-dato etterbetaling")
    val etterbetalingsperiodeFra: LocalDate?,

    @Schema(description = "Til-dato etterbetaling")
    val etterbetalingsperiodeTil: LocalDate?
)

data class SkattegrunnlagDto(

    @Schema(description = "Id til personen inntekten er rapportert for")
    val personId: String,

    @Schema(description = "Periode fra")
    val periodeFra: LocalDate,

    @Schema(description = "Periode frem til")
    val periodeTil: LocalDate,

    @Schema(description = "Angir om en inntektsopplysning er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt inntekten taes i bruk")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt inntekten ikke lenger er aktiv som grunnlag. Null betyr at inntekten er aktiv")
    val brukTil: LocalDateTime?,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime,

    @Schema(description = "Liste over poster med skattegrunnlag")
    val skattegrunnlagListe: List<SkattegrunnlagspostDto>
)

data class SkattegrunnlagspostDto(

    @Schema(description = "Type skattegrunnlag, ordinær eller Svalbard")
    val skattegrunnlagType: String,

    @Schema(description = "Type inntekt, Lonnsinntekt, Naeringsinntekt, Pensjon eller trygd, Ytelse fra offentlig")
    val inntektType: String,

    @Schema(description = "Belop")
    val belop: BigDecimal
)

data class UtvidetBarnetrygdOgSmaabarnstilleggDto(

    @Schema(description = "Id til personen ubst er rapportert for")
    val personId: String,

    @Schema(description = "Type stønad, utvidet barnetrygd eller småbarnstillegg")
    val type: String,

    @Schema(description = "Periode fra- og med måned")
    val periodeFra: LocalDate,

    @Schema(description = "Periode til- og med måned")
    val periodeTil: LocalDate?,

    @Schema(description = "Angir om en stønad er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt inntekten taes i bruk")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt inntekten ikke lenger er aktiv som grunnlag. Null betyr at inntekten er aktiv")
    val brukTil: LocalDateTime?,

    @Schema(description = "Beløp")
    val belop: BigDecimal,

    @Schema(description = "Angir om stønaden er manuelt beregnet")
    val manueltBeregnet: Boolean,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime
)

data class BarnetilleggDto(

    @Schema(description = "Id til personen barnetillegg er rapportert for")
    val partPersonId: String,

    @Schema(description = "Id til barnet barnetillegget er rapportert for")
    val barnPersonId: String,

    @Schema(description = "Type barnetillegg")
    val barnetilleggType: String,

    @Schema(description = "Periode fra- og med måned")
    val periodeFra: LocalDate,

    @Schema(description = "Periode til- og med måned")
    val periodeTil: LocalDate?,

    @Schema(description = "Angir om en stønad er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt stønaden taes i bruk")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt stønaden ikke lenger er aktiv som grunnlag. Null betyr at stønaden er aktiv")
    val brukTil: LocalDateTime?,

    @Schema(description = "Bruttobeløp")
    val belopBrutto: BigDecimal,

    @Schema(description = "Angir om barnet er felles- eller særkullsbarn")
    val barnType: String,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime
)

data class KontantstotteDto(

    @Schema(description = "Id til personen som mottar kontantstøtten")
    val partPersonId: String,

    @Schema(description = "Id til barnet kontantstøtten mottas for")
    val barnPersonId: String,

    @Schema(description = "Periode fra-dato")
    val periodeFra: LocalDate,

    @Schema(description = "Periode til-dato")
    val periodeTil: LocalDate?,

    @Schema(description = "Angir om en inntektsopplysning er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt inntekten tas i bruk")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt inntekten ikke lenger er aktiv som grunnlag. Null betyr at inntekten er aktiv")
    val brukTil: LocalDateTime?,

    @Schema(description = "Beløpet kontantstøtten er på")
    val belop: Int,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime
)

// PDL-data
data class RelatertPersonDto(
    @Schema(description = "Personid til BM/BP")
    val partPersonId: String?,

    @Schema(description = "Personid til relatert person. Dette er husstandsmedlem eller barn av BM/BP")
    val relatertPersonPersonId: String?,

    @Schema(description = "Navn på den relaterte personen, format <Fornavn, mellomnavn, Etternavn")
    val navn: String?,

    @Schema(description = "Den relaterte personens fødselsdato")
    val fodselsdato: LocalDate?,

    @Schema(description = "Angir om den relaterte personen er barn av BM/BP")
    val erBarnAvBmBp: Boolean,

    @Schema(description = "Angir om en grunnlagsopplysning er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt grunnlaget tas i bruk")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt grunnlaget ikke lenger er aktivt. Null betyr at grunnlaget er aktivt")
    val brukTil: LocalDateTime?,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime,

    @Schema(description = "Liste over perioder personen bor i samme husstand som BM/BP")
    val borISammeHusstandDtoListe: List<BorISammeHusstandDto>
)

data class BorISammeHusstandDto(
    @Schema(description = "Personen bor i samme husstand som BM/BP fra- og med måned")
    val periodeFra: LocalDate?,

    @Schema(description = "Personen bor i samme husstand som BM/BP til- og med måned")
    val periodeTil: LocalDate?
)

data class SivilstandDto(
    @Schema(description = "Id til personen sivilstanden er rapportert for")
    val personId: String?,

    @Schema(description = "Sivilstand gjelder fra- og med måned")
    val periodeFra: LocalDate?,

    @Schema(description = "Sivilstand gjelder til- og med måned")
    val periodeTil: LocalDate?,

    @Schema(description = "Personens sivilstand")
    val sivilstand: SivilstandKode,

    @Schema(description = "Angir om en grunnlagsopplysning er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt grunnlaget tas i bruk")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt grunnlaget ikke lenger er aktivt. Null betyr at grunnlaget er aktivt")
    val brukTil: LocalDateTime?,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime
)

data class BarnetilsynDto(

    @Schema(description = "Id til personen som mottar barnetilsynet")
    val partPersonId: String,

    @Schema(description = "Id til barnet barnetilsynet er for")
    val barnPersonId: String,

    @Schema(description = "Periode fra-dato")
    val periodeFra: LocalDate,

    @Schema(description = "Periode til-dato")
    val periodeTil: LocalDate?,

    @Schema(description = "Angir om en stønadsopplysning er aktiv")
    val aktiv: Boolean,

    @Schema(description = "Tidspunkt stønadsopplysningen tas i bruk som grunnlag")
    val brukFra: LocalDateTime,

    @Schema(description = "Tidspunkt stønadsopplysning ikke lenger aktiv som grunnlag. Null betyr at stønadsopplysningen er aktiv")
    val brukTil: LocalDateTime?,

    @Schema(description = "Beløpet barnetilsynet er på")
    val belop: Int?,

    @Schema(description = "Angir om barnetilsynet er heltid eller deltid")
    val tilsynstype: Tilsyntype?,

    @Schema(description = "Angir om barnet er over eller under skolealder")
    val skolealder: Skolealder?,

    @Schema(description = "Hentet tidspunkt")
    val hentetTidspunkt: LocalDateTime
)
