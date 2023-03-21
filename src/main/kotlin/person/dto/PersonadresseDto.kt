package person.dto

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import person.enums.Adressetype

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PersonadresseDto(
    @Schema(description = "Gyldige adressetyper: BOSTEDSADRESSE, KONTAKTADRESSE, eller OPPHOLDSADRESSE")
    var adressetype: Adressetype,

    @Schema(description = "Adresselinje 1")
    var adresselinje1: String? = null,

    @Schema(description = "Adresselinje 2")
    var adresselinje2: String? = null,

    @Schema(description = "Adresselinje 3")
    var adresselinje3: String? = null,

    @Schema(description = "Bruksenhetsnummer")
    var bruksenhetsnummer: String? = null,

    @Schema(description = "Postnummer, tilgjengelig hvis norsk adresse")
    var postnummer: String? = null,

    @Schema(description = "Poststed, tilgjengelig hvis norsk adresse")
    var poststed: String? = null,

    @Schema(description = "To-bokstavers landkode ihht iso3166-1 alfa-2")
    var land: String,

    @Schema(description = "Trebokstavs landkode ihht iso3166-1 alfa-3")
    var land3: String
)