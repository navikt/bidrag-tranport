package no.nav.bidrag.transport.behandling.inntekt.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.transport.behandling.grunnlag.response.AinntektDto
import no.nav.bidrag.transport.behandling.grunnlag.response.KontantstotteDto
import no.nav.bidrag.transport.behandling.grunnlag.response.OvergangsstonadDto
import no.nav.bidrag.transport.behandling.grunnlag.response.SkattegrunnlagspostDto
import no.nav.bidrag.transport.behandling.grunnlag.response.UtvidetBarnetrygdOgSmaabarnstilleggDto

// TODO Legge til swagger-doc, default-verdier
// TODO Legge til evt. manuelle inntekter
// TODO Hva gjør vi med inntekter som ikke er i bruk?

data class TransformerInntekterRequest(
    @Schema(description = "Periodisert liste over inntekter fra Ainntekt")
    val ainntektListe: List<AinntektDto> = emptyList(),

    @Schema(description = "Periodisert liste over inntekter fra Sigrun")
    val skattegrunnlagListe: List<SkattegrunnlagForLigningsår> = emptyList(),

    @Schema(description = "Periodisert liste over utvidet barnetrygd og småbarnstillegg")
    val ubstListe: List<UtvidetBarnetrygdOgSmaabarnstilleggDto> = emptyList(),

    @Schema(description = "Periodisert liste over kontantstøtte")
    val kontantstotteListe: List<KontantstotteDto> = emptyList(),

    @Schema(description = "Periodisert liste over overgangsstønad")
    val overgangsstonadListe: List<OvergangsstonadDto> = emptyList()
)

data class SkattegrunnlagForLigningsår(

    @Schema(description = "Årstall skattegrunnlaget gjelder for")
    val ligningsår: Int,

    @Schema(description = "Poster med skattegrunnlag")
    val skattegrunnlagsposter: List<SkattegrunnlagspostDto>

)
