package no.nav.bidrag.transport.organisasjon

import no.nav.bidrag.domene.enums.Behandlingstype
import no.nav.bidrag.domene.enums.Sakskategori
import no.nav.bidrag.domene.ident.PersonIdent
import no.nav.bidrag.domene.string.Behandlingstema
import no.nav.bidrag.domene.string.TEMA_BIDRAG
import no.nav.bidrag.domene.string.Tema

data class HentEnhetRequest(
    val ident: PersonIdent,
    val biidenter: Set<PersonIdent> = setOf(),
    val tema: Tema = TEMA_BIDRAG,
    val behandlingstema: Behandlingstema? = null,
    val sakskategori: Sakskategori? = null,
    val behandlingstype: Behandlingstype? = null,

) {

    val alleIdenter get() = biidenter + ident
}
