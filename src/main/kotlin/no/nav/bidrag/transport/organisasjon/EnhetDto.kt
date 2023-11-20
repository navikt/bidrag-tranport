package no.nav.bidrag.transport.organisasjon

import no.nav.bidrag.domene.adresse.Adresselinje1
import no.nav.bidrag.domene.adresse.Adresselinje2
import no.nav.bidrag.domene.adresse.Postnummer
import no.nav.bidrag.domene.adresse.Poststed
import no.nav.bidrag.domene.enums.diverse.Enhetsstatus
import no.nav.bidrag.domene.offentlig.Kommunenummer
import no.nav.bidrag.domene.organisasjon.Enhetsnavn
import no.nav.bidrag.domene.organisasjon.Enhetsnummer

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
    val telefonnummer: String? = null,
    val postadresse: EnhetspostadresseDto? = null,

) {

    companion object {
        fun medStandardadresse(enhetsnummer: Enhetsnummer) = EnhetKontaktinfoDto(
            nummer = enhetsnummer,
            navn = Enhetsnavn("NAV Familie- og pensjonsytelser"),
            telefonnummer = "55553333",
            postadresse = EnhetspostadresseDto(
                postnummer = Postnummer("0603"),
                adresselinje1 = Adresselinje1("Postboks 6215 Etterstad"),
                poststed = Poststed("Oslo"),
                land = "Norway",
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
    val land: String? = null,
    val kommunenr: Kommunenummer? = null,
)
