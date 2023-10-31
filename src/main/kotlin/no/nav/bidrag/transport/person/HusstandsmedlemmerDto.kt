package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.ident.PersonIdent
import no.nav.bidrag.domene.string.Adressenavn
import no.nav.bidrag.domene.string.Bruksenhetsnummer
import no.nav.bidrag.domene.string.Bydelsnummer
import no.nav.bidrag.domene.string.FulltNavn
import no.nav.bidrag.domene.string.Husbokstav
import no.nav.bidrag.domene.string.Husnummer
import no.nav.bidrag.domene.string.Kommunenummer
import no.nav.bidrag.domene.string.Postnummer
import no.nav.bidrag.domene.tall.MatrikkelId
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
