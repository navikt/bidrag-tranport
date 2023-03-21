package person.dto

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import person.enums.KjoennType
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PersonDto(
    @Schema(description = "Identen til personen")
    var ident: String,

    @Schema(description = "Navn til personen, format <Etternavn, Fornavn Middelnavn>")
    var navn: String? = null,

    @Schema(description = "Fornavn til personen")
    var fornavn: String? = null,

    @Schema(description = "Mellomnavn til personen")
    var mellomnavn: String? = null,

    @Schema(description = "Etternavn til personen")
    var etternavn: String? = null,

    @Schema(description = "Kjønn til personen")
    var kjoenn: KjoennType? = null,

    @Schema(description = "Dødsdato til personen")
    var doedsdato: LocalDate? = null,

    @Schema(description = "Fødselsdato til personen")
    var foedselsdato: LocalDate? = null,

    @Schema(description = "Diskresjonskode (personvern)")
    var diskresjonskode: String? = null,

    @Schema(description = "Aktør id til personen")
    var aktoerId: String? = null,

    @Schema(description = "Kortnavn på personen, navn som benyttes ved maskinelle utskrifter (maks 40 tegn)", deprecated = true)
    var kortNavn: String? = null,

    @Schema(description = "Kortnavn på personen, navn som benyttes ved maskinelle utskrifter (maks 40 tegn)")
    var kortnavn: String? = null
)
