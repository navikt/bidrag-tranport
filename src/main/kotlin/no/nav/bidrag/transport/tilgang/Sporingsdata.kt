package no.nav.bidrag.transport.tilgang

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Sporingdata til auditlogging")
class Sporingsdata(
    @Schema(description = "Fødselsnummer på primærpersonen i oppslaget.")
    val personIdent: String,
    @Schema(description = "Hvor vist personen som gjør oppslaget har tilgang til å gjøre oppslaget.")
    val tilgang: Boolean,
    @Schema(description = """Ekstrainformasjonsfelter. Navn og verdi. Eksempelvis mapOf("saksnummer" to "2302845")""")
    val ekstrafelter: List<Pair<String, String>> = listOf()
)
