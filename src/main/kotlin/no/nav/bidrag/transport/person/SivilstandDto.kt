package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.annotations.ApiModel
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.person.SivilstandskodePDL
import no.nav.bidrag.transport.behandling.grunnlag.response.SivilstandDto
import java.time.LocalDate
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SivilstandshistorikkDto(
    @Schema(description = "Liste over alle hentede forekomster av sivilstand fra bidrag-person")
    val sivilstandDto: List<SivilstandDto>,
)

@ApiModel("SivilstandDtoPerson")
data class SivilstandDto(
    val type: SivilstandskodePDL?,
    val gyldigFraOgMed: LocalDate?,
    val bekreftelsesdato: LocalDate?,
    val master: String?,
    val registrert: LocalDateTime?,
    val historisk: Boolean?,
)
