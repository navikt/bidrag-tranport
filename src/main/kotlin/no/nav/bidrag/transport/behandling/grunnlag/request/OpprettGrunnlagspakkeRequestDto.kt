package no.nav.bidrag.transport.behandling.grunnlag.request

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.vedtak.Formål

@Schema(description = "Request for å opprette ny grunnlagspakke, uten annet innhold")
data class OpprettGrunnlagspakkeRequestDto(

    @Schema(description = "Til hvilket formål skal grunnlagspakken benyttes. BIDRAG, FORSKUDD eller SAERTILSKUDD")
    val formaal: Formål,

    @Schema(description = "Skal bare brukes ved batchkjøring. Id til batchjobb som oppretter grunnlagspakken")
    val opprettetAv: String? = null,
)
