package no.nav.bidrag.transport.person

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.Gradering
import no.nav.bidrag.domain.ident.PersonIdent

data class Graderingsinfo(
    @Schema(description = "Map med ident til gradering.")
    val identerTilGradering: Map<PersonIdent, Gradering?>,
    @Schema(description = "Hvor vidt hovedident fra GraderingQuery er skjerment.")
    val identerTilSkjerming: Map<PersonIdent, Boolean>,
)
