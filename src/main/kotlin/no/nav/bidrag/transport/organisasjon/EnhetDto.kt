package no.nav.bidrag.transport.organisasjon

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.enums.Enhetsstatus
import no.nav.bidrag.domain.string.Adresselinje1
import no.nav.bidrag.domain.string.Adresselinje2
import no.nav.bidrag.domain.string.Enhetsnavn
import no.nav.bidrag.domain.string.Enhetsnummer
import no.nav.bidrag.domain.string.Kommunenummer
import no.nav.bidrag.domain.string.Landnavn
import no.nav.bidrag.domain.string.Postnummer
import no.nav.bidrag.domain.string.Poststed
import no.nav.bidrag.domain.string.Telefonnummer

@Schema(description = "Metadata for en enhet")
data class EnhetDto(
    val nummer: Enhetsnummer? = null,
    val navn: Enhetsnavn? = null,
    @Deprecated("bruk nummer", ReplaceWith("nummer"))
    val enhetIdent: Enhetsnummer? = nummer,
    @Deprecated("bruk navn", ReplaceWith("navn"))
    val enhetNavn: Enhetsnavn? = navn,
    val status: Enhetsstatus? = Enhetsstatus.AKTIV
)

@Schema(description = "Metadata for en enhet postadresse")
data class EnhetKontaktinfoDto(
    val nummer: Enhetsnummer? = null,
    val navn: Enhetsnavn? = Enhetsnavn("NAV Familie- og pensjonsytelser"),
    @Deprecated("bruk nummer", ReplaceWith("nummer"))
    val enhetIdent: Enhetsnummer? = nummer,
    @Deprecated("bruk navn", ReplaceWith("navn"))
    val enhetNavn: Enhetsnavn? = navn,
    val telefonnummer: Telefonnummer? = Telefonnummer("55553333"),
    val postadresse: EnhetspostadresseDto? = null
)

data class EnhetspostadresseDto(
    val postnummer: Postnummer? = Postnummer("0603"),
    val adresselinje1: Adresselinje1? = Adresselinje1("Postboks 6215 Etterstad"),
    val adresselinje2: Adresselinje2? = null,
    val poststed: Poststed? = Poststed("Oslo"),
    val land: Landnavn? = Landnavn("Norway"),
    val kommunenr: Kommunenummer? = Kommunenummer("0301")
)
