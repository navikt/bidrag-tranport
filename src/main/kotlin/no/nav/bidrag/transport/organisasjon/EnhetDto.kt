package no.nav.bidrag.transport.organisasjon

import no.nav.bidrag.domene.enums.Enhetsstatus
import no.nav.bidrag.domene.string.Adresselinje1
import no.nav.bidrag.domene.string.Adresselinje2
import no.nav.bidrag.domene.string.Enhetsnavn
import no.nav.bidrag.domene.string.Enhetsnummer
import no.nav.bidrag.domene.string.Kommunenummer
import no.nav.bidrag.domene.string.Landnavn
import no.nav.bidrag.domene.string.Postnummer
import no.nav.bidrag.domene.string.Poststed
import no.nav.bidrag.domene.string.Telefonnummer

data class EnhetDto(
    val nummer: Enhetsnummer,
    val navn: Enhetsnavn? = null,
    @Deprecated("bruk nummer", ReplaceWith("nummer"))
    val enhetIdent: Enhetsnummer = nummer,
    @Deprecated("bruk navn", ReplaceWith("navn"))
    val enhetNavn: Enhetsnavn? = navn,
    val status: Enhetsstatus = Enhetsstatus.AKTIV,
)

data class EnhetKontaktinfoDto(
    val nummer: Enhetsnummer,
    val navn: Enhetsnavn? = null,
    @Deprecated("bruk nummer", ReplaceWith("nummer"))
    val enhetIdent: Enhetsnummer = nummer,
    @Deprecated("bruk navn", ReplaceWith("navn"))
    val enhetNavn: Enhetsnavn? = navn,
    val telefonnummer: Telefonnummer? = null,
    val postadresse: EnhetspostadresseDto? = null,

) {

    companion object {
        fun medStandardadresse(enhetsnummer: Enhetsnummer) = EnhetKontaktinfoDto(
            nummer = enhetsnummer,
            navn = Enhetsnavn("NAV Familie- og pensjonsytelser"),
            telefonnummer = Telefonnummer("55553333"),
            postadresse = EnhetspostadresseDto(
                postnummer = Postnummer("0603"),
                adresselinje1 = Adresselinje1("Postboks 6215 Etterstad"),
                poststed = Poststed("Oslo"),
                land = Landnavn("Norway"),
                kommunenr = Kommunenummer("0301"),
            ),
        )
    }
}

data class EnhetspostadresseDto(
    val postnummer: Postnummer? = null,
    val adresselinje1: Adresselinje1? = null,
    val adresselinje2: Adresselinje2? = null,
    val poststed: Poststed? = null,
    val land: Landnavn? = null,
    val kommunenr: Kommunenummer? = null,
)
