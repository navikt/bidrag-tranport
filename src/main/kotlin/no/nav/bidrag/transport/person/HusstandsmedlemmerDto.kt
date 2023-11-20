package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.adresse.Bruksenhetsnummer
import no.nav.bidrag.domene.adresse.Postnummer
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.offentlig.Kommunenummer
import no.nav.bidrag.domene.person.FulltNavn
import no.nav.bidrag.domene.tid.Dødsdato
import no.nav.bidrag.domene.tid.FomDato
import no.nav.bidrag.domene.tid.Fødselsdato
import no.nav.bidrag.domene.tid.TomDato

@JsonInclude(JsonInclude.Include.NON_NULL)
data class HusstandsmedlemmerDto(
    @Schema(description = "Periodiser liste over husstander og dens medlemmer i perioden")
    val husstandListe: List<Husstand> = emptyList(),
)

data class Husstand(
    val gyldigFraOgMed: FomDato?,
    val gyldigTilOgMed: TomDato?,
    val adressenavn: String? = null,
    val husnummer: String? = null,
    val husbokstav: String? = null,
    val bruksenhetsnummer: Bruksenhetsnummer? = null,
    val postnummer: Postnummer? = null,
    val bydelsnummer: String? = null,
    val kommunenummer: Kommunenummer? = null,
    val matrikkelId: Long? = null,
    val husstandsmedlemListe: List<Husstandsmedlem>,
)

data class Husstandsmedlem(
    val gyldigFraOgMed: FomDato?,
    val gyldigTilOgMed: TomDato?,
    val personId: Personident,
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
