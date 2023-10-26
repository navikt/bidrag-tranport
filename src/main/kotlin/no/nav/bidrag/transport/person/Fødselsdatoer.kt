package no.nav.bidrag.transport.person

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.tid.Fødselsdato

data class Fødselsdatoer(
    @Schema(description = "Map med ident til fødselsdato-elementer.")
    val identerTilDatoer: Map<PersonIdent, Fødselsdato?>,
)
