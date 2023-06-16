package no.nav.bidrag.transport.behandling.grunnlag.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import no.nav.bidrag.domain.enums.Formaal

@Schema(description = "Request for å opprette ny grunnlagspakke, uten annet innhold")
data class OpprettGrunnlagspakkeRequestDto(

    @Schema(description = "Til hvilket formål skal grunnlagspakken benyttes. BIDRAG, FORSKUDD eller SAERTILSKUDD")
    val formaal: Formaal,

    @Schema(description = "opprettet av")
    @field:NotBlank(message = "Kan ikke være null eller blank.")
    val opprettetAv: String
)
