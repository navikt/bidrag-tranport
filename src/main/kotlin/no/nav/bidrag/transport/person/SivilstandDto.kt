package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.Sivilstandstype
import no.nav.bidrag.domain.tid.Bekreftelsesdato
import no.nav.bidrag.domain.tid.FomDato

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SivilstandDto(
    @Schema(description = "Liste over alle hentede forekomster av sivilstand")
    val sivilstand: List<Sivilstand>
)

data class Sivilstand(
    val type: Sivilstandstype?,
    val gyldigFraOgMed: FomDato?,
    val bekreftelsesdato: Bekreftelsesdato?
)
