package no.nav.bidrag.transport.samhandler

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.string.Bankkode
import no.nav.bidrag.domain.string.Banknavn
import no.nav.bidrag.domain.string.Iban
import no.nav.bidrag.domain.string.Landkode3
import no.nav.bidrag.domain.string.NorskKontonummer
import no.nav.bidrag.domain.string.Swift
import no.nav.bidrag.domain.string.Valutakode

@Schema(
    description = "Representerer kontonummer for en samhandler. For norske kontonummer " +
        "er det kun norskKontornr som er utfyllt, ellers benyttes de andre feltene for utlandske kontonummer.",
)
data class KontonummerDto(
    @Schema(description = "Norsk kontonummer, 11 siffer.")
    val norskKontonummer: NorskKontonummer? = null,
    @Schema(description = "IBAN angir kontonummeret på et internasjonalt format.")
    val iban: Iban? = null,
    @Schema(description = "SWIFT angir banken på et internasjonalt format.")
    val swift: Swift? = null,
    @Schema(description = "Bankens navn.")
    val banknavn: Banknavn? = null,
    @Schema(description = "Bankens landkode. ISO 3166-1 alfa-3.")
    val landkodeBank: Landkode3? = null,
    @Schema(description = "BankCode. Format varierer.")
    val bankCode: Bankkode? = null,
    @Schema(description = "Kontoens valuta.")
    val valutakode: Valutakode? = null,
)
