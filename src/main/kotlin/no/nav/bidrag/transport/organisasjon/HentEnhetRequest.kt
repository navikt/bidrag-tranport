package no.nav.bidrag.transport.organisasjon

import no.nav.bidrag.domene.enums.sak.Sakskategori
import no.nav.bidrag.domene.enums.vedtak.Behandlingstype
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.organisasjon.Behandlingstema
import no.nav.bidrag.domene.organisasjon.TEMA_BIDRAG
import no.nav.bidrag.domene.organisasjon.Tema

data class HentEnhetRequest(
    val ident: Personident,
    val biidenter: Set<Personident> = setOf(),
    val tema: Tema = TEMA_BIDRAG,
    val behandlingstema: Behandlingstema? = null,
    val sakskategori: Sakskategori? = null,
    val behandlingstype: Behandlingstype? = null,

) {

    val alleIdenter get() = biidenter + ident
}
