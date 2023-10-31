package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.string.Bankkode
import no.nav.bidrag.domene.string.Banknavn
import no.nav.bidrag.domene.string.Iban
import no.nav.bidrag.domene.string.Landkode
import no.nav.bidrag.domene.string.NorskKontonummer
import no.nav.bidrag.domene.string.Swift
import no.nav.bidrag.domene.tid.OpprettetTidspunkt

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Representerer kontonummer for en person. For norske kontonummer er det kun norskKontornr som er utfyllt, ellers benyttes de andre feltene for utlandske kontonummer.")
data class KontonummerDto(
    @Schema(description = "Norsk kontonummer, 11 siffer.")
    val norskKontonr: NorskKontonummer? = null,
    @Schema(description = "IBAN angir kontonummeret på et internasjonalt format.")
    val iban: Iban? = null,
    @Schema(description = "SWIFT angir banken på et internasjonalt format")
    val swift: Swift? = null,
    @Schema(description = "Bankens navn.")
    val banknavn: Banknavn? = null,
    @Schema(description = "Bankens landkode.")
    val banklandkode: Landkode? = null,
    @Schema(description = "BankCode. Format varierer.")
    val bankkode: Bankkode? = null,
    @Schema(description = "Bankkode. Format varierer.", deprecated = true)
    @Deprecated("Skrivefeil", ReplaceWith("bankkode"))
    val bankcode: Bankkode? = bankkode,
    @Schema(description = "Kontoens valuta.")
    val valutakode: String? = null,
    @Schema(description = "Adressefelt 1, utenlandsk bank")
    val bankadresse1: String? = null,
    @Schema(description = "Adressefelt 2, utenlandsk bank")
    val bankadresse2: String? = null,
    @Schema(description = "Adressefelt 3, utenlandsk bank")
    val bankadresse3: String? = null,
    @Schema(description = "Tilleggsinformasjon")
    val metadata: MetadataDto,
)

data class MetadataDto(
    val gyldigFom: OpprettetTidspunkt,
    val opprettetAv: String,
    val kilde: String?,
)
