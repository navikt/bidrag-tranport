package no.nav.bidrag.transport.samhandler

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.string.FulltNavn
import no.nav.bidrag.domene.string.Område
import no.nav.bidrag.domene.string.Postnummer
import no.nav.bidrag.transport.felles.QueryObject

@Schema(description = "Query-felter for søk etter samhandlere.")
data class SøkSamhandlerQuery(
    val navn: FulltNavn,
    val postnummer: Postnummer? = null,
    @JsonProperty("omrade")
    val område: Område? = null,
    @Schema(description = "Sidenummer med resultater man ønsker, hvis det finnes og man ønsker påfølgende resultater.")
    val side: Int = 0,
) : QueryObject
