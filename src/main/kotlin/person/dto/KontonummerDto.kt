package person.dto

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Representerer kontonummer for en person. For norske kontonummer er det kun norskKontornr som er utfyllt, ellers benyttes de andre feltene for utlandske kontonummer.")
data class KontonummerDto(

    @Schema(description = "Norsk kontonummer, 11 siffer.")
    val norskKontonr: String? = null,

    @Schema(description = "IBAN angir kontonummeret på et internasjonalt format.")
    var iban: String? = null,

    @Schema(description = "SWIFT angir banken på et internasjonalt format")
    var swift: String? = null,

    @Schema(description = "Bankens navn.")
    var banknavn: String? = null,

    @Schema(description = "Bankens landkode.")
    var banklandkode: String? = null,

    @Schema(description = "BankCode. Format varierer.")
    var bankcode: String? = null,

    @Schema(description = "Kontoens valuta.")
    var valutakode: String? = null
)