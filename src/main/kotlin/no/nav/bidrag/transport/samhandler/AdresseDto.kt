package no.nav.bidrag.transport.samhandler

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.adresse.Adresselinje1
import no.nav.bidrag.domene.adresse.Adresselinje2
import no.nav.bidrag.domene.adresse.Adresselinje3
import no.nav.bidrag.domene.adresse.Postnummer
import no.nav.bidrag.domene.adresse.Poststed
import no.nav.bidrag.domene.land.Landkode3

@Schema(description = "Representerer navn og/eller adresse for en samhandler.")
data class AdresseDto(
    @Schema(description = "Første adresselinje inneholder normalt gatenavn, men kan også innehold f.eks c/o.")
    val adresselinje1: Adresselinje1? = null,

    @Schema(description = "Andre adresselinje brukes primært i utlandsadresser, hvor postnr og poststed ikke er tilgjengelig som strukturerte data.")
    val adresselinje2: Adresselinje2? = null,

    @Schema(description = "Tredje adresselinje brukes i noen tilfeller til region.")
    val adresselinje3: Adresselinje3? = null,

    @Schema(description = "Postnr dersom dette er tilgjengelig som strukturerte data.")
    val postnr: Postnummer? = null,

    @Schema(description = "Poststed dersom dette er tilgjengelig som strukturerte data.")
    val poststed: Poststed? = null,

    @Schema(description = "Land. ISO 3166-1 alfa-3.")
    val land: Landkode3? = null,
)
