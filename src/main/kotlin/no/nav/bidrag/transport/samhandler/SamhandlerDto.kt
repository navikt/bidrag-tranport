package no.nav.bidrag.transport.samhandler

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.ident.OffentligId
import no.nav.bidrag.domain.ident.SamhandlerId
import no.nav.bidrag.domain.string.FulltNavn
import no.nav.bidrag.domain.string.OffentligIdtype

data class SamhandlerDto(
    val tssId: SamhandlerId,
    @Schema(description = "Navn på samhandler")
    val navn: FulltNavn?,

    @Schema(description = "Offentlig id for samhandlere.")
    val offentligId: OffentligId? = null,

    @Schema(description = "Type offentlig id. F.eks ORG for norske organisasjonsnummere.")
    val offentligIdType: OffentligIdtype? = null,

    @Schema(description = "Samhandlerens adresse.")
    val adresse: AdresseDto? = null,

    @Schema(description = "Samhandlerens kontonummer. Kontonummer er ikke inkludert i søkeresultat, kun i oppslag.")
    val kontonummer: KontonummerDto? = null,
)
