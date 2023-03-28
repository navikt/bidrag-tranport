package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.felles.Verdiobjekt

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PersonRequest(
    @Schema(description = "Identen til personen", deprecated = true)
    @Deprecated("Hvis verdi tas i bruk i stedet for ident, så kan hele objektet byttes med personIdent fra bidrag-domain", ReplaceWith("verdi"))
    val ident: String? = null,
    @Schema(description = "Identen til personen")
    override val verdi: String = ident ?: error("PersonRequest må ha feltet verdi eller ident.")
) : Verdiobjekt<String>()
