package no.nav.bidrag.transport.sak

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.string.Enhet
import no.nav.bidrag.domain.string.Saksnummer

@Schema(description = "Data som trengs for å opprette et saksnummer for en bidragssak")
data class NySakCommandDto(
    @Schema(description = "Sakens eierfogd (enhetsnummeret som får tilgang til saken")
    val eierfogd: Enhet
)

@Schema(description = "Response ved opprettelse av sak")
data class NySakResponseDto(
    @Schema(description = "Saksnummer som ble tildelt ")
    val saksnummer: Saksnummer
)
