package no.nav.bidrag.transport.sak

import no.nav.bidrag.domene.bool.Ukjent
import no.nav.bidrag.domene.enums.Rolletype
import no.nav.bidrag.domene.ident.NavCallId
import no.nav.bidrag.domene.ident.PersonIdent
import no.nav.bidrag.domene.ident.ReellMottager
import no.nav.bidrag.domene.ident.SamhandlerId
import no.nav.bidrag.domene.string.Saksnummer

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
