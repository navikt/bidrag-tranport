package no.nav.bidrag.transport.person

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.number.Fødselsår
import no.nav.bidrag.domain.string.FulltNavn
import no.nav.bidrag.domain.tid.Dødsdato
import no.nav.bidrag.domain.tid.Fødselsdato

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NavnFødselDødDto(
    @Schema(
        description = "Gir navn, fødselsdato og fødselsår for angitt person. Fødselsår finnes for alle i PDL, mens noen ikke har utfyllt fødselsdato",
    )
    val navn: FulltNavn,
    val fødselsdato: Fødselsdato?,
    val fødselsår: Fødselsår,
    @Schema(description = "Eventuell dødsdato til personen")
    val dødsdato: Dødsdato?,
    @Schema(deprecated = true)
    @Deprecated("Skrivefeil", ReplaceWith("fødselsdato"))
    val foedselsdato: Fødselsdato? = fødselsdato,
    @Schema(deprecated = true)
    @Deprecated("Skrivefeil", ReplaceWith("fødselsår"))
    val foedselsaar: Fødselsår = fødselsår,
    @Schema(description = "Eventuell dødsdato til personen", deprecated = true)
    @Deprecated("Skrivefeil", ReplaceWith("dødsdato"))
    val doedsdato: Dødsdato? = dødsdato,
)
