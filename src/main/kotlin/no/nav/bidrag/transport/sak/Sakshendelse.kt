package no.nav.bidrag.transport.sak

import no.nav.bidrag.domain.bool.Ukjent
import no.nav.bidrag.domain.enums.Rolletype
import no.nav.bidrag.domain.ident.NavCallId
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.ident.ReellMottager
import no.nav.bidrag.domain.ident.SamhandlerId
import no.nav.bidrag.domain.string.Saksnummer

data class Sakshendelse(
    val saksnummer: Saksnummer,
    val hendelsestype: Sakshendelsestype,
    val roller: List<Saksrolle> = emptyList(),
    val sporingId: NavCallId,
)

data class Saksrolle(
    val ident: PersonIdent? = null,
    val type: Rolletype,
    val samhandlerId: SamhandlerId? = null,
    val reelMottager: ReellMottager? = null,
    val ukjent: Ukjent = Ukjent(false),
)
enum class Sakshendelsestype {
    ENDRING,
    OPPRETTELSE,
}
