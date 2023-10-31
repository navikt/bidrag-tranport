package no.nav.bidrag.transport.person

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.Skifteform
import no.nav.bidrag.domene.string.Adresselinje1
import no.nav.bidrag.domene.string.Adresselinje2
import no.nav.bidrag.domene.string.Kontaktperson
import no.nav.bidrag.domene.string.Landkode3
import no.nav.bidrag.domene.string.Postnummer
import no.nav.bidrag.domene.string.Poststed
import no.nav.bidrag.domene.tid.Attestutstedelsesdato

data class DødsboDto(
    @Schema(description = "Fra Tingretten angis skifteformen for booppgjøret.")
    val skifteform: Skifteform,
    @Schema(description = "Attestutstedelsesdato for skifteattest.")
    val attestutstedelsesdato: Attestutstedelsesdato,
    @Schema(description = "Kontaktadresse i Norge eller utlandet for person, advokat eller oganisasjon.")
    val kontaktadresse: DødsboKontaktadresse,
    @Schema(description = "Navn på kontaktperson for dødsboet. Dette kan være en person, advokat eller oganisasjon.")
    val kontaktperson: Kontaktperson,
)

data class DødsboKontaktadresse(
    @Schema(description = "Adresselinje 1")
    val adresselinje1: Adresselinje1,
    @Schema(description = "Adresselinje 2")
    val adresselinje2: Adresselinje2? = null,
    @Schema(description = "Postnummer.")
    val postnummer: Postnummer,
    @Schema(description = "Poststed")
    val poststed: Poststed,
    @Schema(description = "Landkode 3 siffer.")
    val land3: Landkode3?,
)
