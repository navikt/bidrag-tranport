package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.person.Sivilstandstype
import no.nav.bidrag.domene.tid.Bekreftelsesdato
import no.nav.bidrag.domene.tid.FomDato
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SivilstandshistorikkDto(
    @Schema(description = "Liste over alle hentede forekomster av sivilstand fra bidrag-person")
    val sivilstandDto: List<SivilstandDto>,
)

data class SivilstandDto(
    val type: Sivilstandstype?,
    val gyldigFraOgMed: FomDato?,
    val bekreftelsesdato: Bekreftelsesdato?,
    val master: String?,
    val registrert: LocalDateTime?,
    val historisk: Boolean?,
)
