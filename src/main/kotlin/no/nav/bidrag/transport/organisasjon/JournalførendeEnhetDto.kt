package no.nav.bidrag.transport.organisasjon

import no.nav.bidrag.domain.string.Enhetsnavn
import no.nav.bidrag.domain.string.Enhetsnummer
import no.nav.bidrag.domain.string.Enhetstype

data class JournalførendeEnhetDto(
    val nummer: Enhetsnummer? = null,
    val navn: Enhetsnavn? = null,
    val type: Enhetstype? = null,
    @Deprecated("bruk nummer", ReplaceWith("nummer"))
    val enhetIdent: Enhetsnummer? = nummer,
    @Deprecated("bruk navn", ReplaceWith("navn"))
    val enhetNavn: Enhetsnavn? = navn,
    @Deprecated("bruk type", ReplaceWith("type"))
    val enhetType: Enhetstype? = type,
)
