package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.number.MatrikkelId
import no.nav.bidrag.domain.string.Adressenavn
import no.nav.bidrag.domain.string.Bruksenhetsnummer
import no.nav.bidrag.domain.string.Bydelsnummer
import no.nav.bidrag.domain.string.FulltNavn
import no.nav.bidrag.domain.string.Husbokstav
import no.nav.bidrag.domain.string.Husnummer
import no.nav.bidrag.domain.string.Kommunenummer
import no.nav.bidrag.domain.string.Postnummer
import no.nav.bidrag.domain.tid.Dødsdato
import no.nav.bidrag.domain.tid.FomDato
import no.nav.bidrag.domain.tid.Fødselsdato
import no.nav.bidrag.domain.tid.TomDato

@JsonInclude(JsonInclude.Include.NON_NULL)
data class HusstandsmedlemmerDto(
    @Schema(description = "Periodiser liste over husstander og dens medlemmer i perioden")
    val husstandListe: List<Husstand> = emptyList(),
)

data class Husstand(
    val gyldigFraOgMed: FomDato?,
    val gyldigTilOgMed: TomDato?,
    val adressenavn: Adressenavn? = null,
    val husnummer: Husnummer? = null,
    val husbokstav: Husbokstav? = null,
    val bruksenhetsnummer: Bruksenhetsnummer? = null,
    val postnummer: Postnummer? = null,
    val bydelsnummer: Bydelsnummer? = null,
    val kommunenummer: Kommunenummer? = null,
    val matrikkelId: MatrikkelId? = null,
    val husstandsmedlemListe: List<Husstandsmedlem>,
)

data class Husstandsmedlem(
    val gyldigFraOgMed: FomDato?,
    val gyldigTilOgMed: TomDato?,
    val personId: PersonIdent,
    val navn: FulltNavn,
    val fødselsdato: Fødselsdato? = null,
    val dødsdato: Dødsdato? = null,
    @Schema(deprecated = true)
    @Deprecated("Skrivefeil", ReplaceWith("fødselsdato"))
    val foedselsdato: Fødselsdato? = fødselsdato,
    @Schema(deprecated = true)
    @Deprecated("Skrivefeil", ReplaceWith("dødsdato"))
    val doedsdato: Dødsdato? = dødsdato,
)
