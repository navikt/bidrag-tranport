package no.nav.bidrag.transport.sak

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.bool.MottagerErVerge
import no.nav.bidrag.domain.enums.Rolletype
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.ident.ReellMottager
import no.nav.bidrag.domain.ident.SamhandlerId
import no.nav.bidrag.domain.string.Objektnummer

data class RolleDto(
    @JsonProperty("fodselsnummer")
    val fødselsnummer: PersonIdent? = null,
    @Schema(description = "Kode for rolletype tilsvarende kodene i T_KODE_ROLLETYPE.")
    val type: Rolletype,
    @Deprecated("Internlogisk felt, burde ikke brukes utenfor back end.")
    val objektnummer: Objektnummer? = null,
    val reellMottager: ReellMottager? = null,
    val mottagerErVerge: MottagerErVerge = MottagerErVerge(false),
    val samhandlerIdent: SamhandlerId? = null,
    @Deprecated("Bruk fødselsnummer", ReplaceWith("fødselsnummer"))
    val foedselsnummer: PersonIdent? = fødselsnummer,
    @Deprecated("Bruk rolletype", ReplaceWith("type"))
    val rolleType: Rolletype = type
) {
    fun valider() {
        require(reellMottager == null || type == Rolletype.BARN) { "Reell mottager kan kun opprettes for barn." }
    }

    fun rmErSamhandlerId() = reellMottager?.erSamhandlerId() ?: false

    fun rmSamhandlerId() = reellMottager?.samhandlerId()
    fun rmFødselsnummer() = reellMottager?.personIdent()
}
