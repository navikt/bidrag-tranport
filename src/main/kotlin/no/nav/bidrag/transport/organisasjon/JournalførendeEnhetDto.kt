package no.nav.bidrag.transport.organisasjon

import no.nav.bidrag.domene.organisasjon.Enhetsnavn
import no.nav.bidrag.domene.organisasjon.Enhetsnummer

data class JournalførendeEnhetDto(
    val nummer: Enhetsnummer? = null,
    val navn: Enhetsnavn? = null,
    val type: String? = null,
    @Deprecated("bruk nummer", ReplaceWith("nummer"))
    val enhetIdent: Enhetsnummer? = nummer,
    @Deprecated("bruk navn", ReplaceWith("navn"))
    val enhetNavn: Enhetsnavn? = navn,
    @Deprecated("bruk type", ReplaceWith("type"))
    val enhetType: String? = type,
)
