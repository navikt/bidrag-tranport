package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.Familierelasjon
import no.nav.bidrag.domain.ident.PersonIdent

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ForelderBarnRelasjonDto(
    @Schema(description = "Liste over alle hentede forekomster av foreldre-barnrelasjoner")
    val forelderBarnRelasjon: List<ForelderBarnRelasjon> = listOf(),
)

data class ForelderBarnRelasjon(
    val minRolleForPerson: Familierelasjon,
    val relatertPersonsIdent: PersonIdent?,
    @Schema(description = "Hvilken rolle personen i requesten har til personen i responsen")
    val relatertPersonsRolle: Familierelasjon,
) {
    fun erRelatertPersonsBarn(): Boolean = relatertPersonsRolle == Familierelasjon.BARN
}
