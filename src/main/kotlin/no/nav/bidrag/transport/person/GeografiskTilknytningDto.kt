package no.nav.bidrag.transport.person

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.person.Diskresjonskode
import no.nav.bidrag.domene.ident.AktørId
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.person.bool.Utland

data class GeografiskTilknytningDto(
    @Schema(description = "Identen til personen")
    val ident: Personident,
    @Schema(description = "Aktørid til personen")
    val aktørId: AktørId? = null,
    @Schema(description = "Aktørid til personen", deprecated = true)
    @Deprecated("Skrivefeil", ReplaceWith("aktørId"))
    val aktoerId: AktørId? = aktørId,
    @Schema(description = "Geografisk tilknytning til personen")
    val geografiskTilknytning: String? = null,
    @Schema(
        description = "Om geografisk tilknytning til personen er utlandet. " +
            "Geografisktilknytning feltet vil da ha landkode istedenfor kommune/bydel nummer",
    )
    val erUtland: Utland = Utland(false),
    @Schema(description = "Diskresjonskode (personvern)")
    val diskresjonskode: Diskresjonskode? = null,
)
