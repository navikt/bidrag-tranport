package no.nav.bidrag.transport.behandling.vedtak

import no.nav.bidrag.domene.enums.Beslutningstype
import no.nav.bidrag.domene.enums.Engangsbeløptype
import no.nav.bidrag.domene.enums.Innkrevingstype
import no.nav.bidrag.domene.enums.Stønadstype
import no.nav.bidrag.domene.enums.Vedtakskilde
import no.nav.bidrag.domene.enums.Vedtakstype
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.streng.Enhetsnummer
import no.nav.bidrag.domene.streng.Saksnummer
import no.nav.bidrag.domene.tid.ÅrMånedsperiode
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class VedtakHendelse(
    val kilde: Vedtakskilde,
    val type: Vedtakstype,
    val id: Int,
    val vedtakstidspunkt: LocalDateTime,
    val enhetsnummer: Enhetsnummer,
    val innkrevingUtsattTilDato: LocalDate?,
    val fastsattILand: String?,
    val opprettetAv: String,
    val opprettetAvNavn: String?,
    val opprettetTidspunkt: LocalDateTime,
    val stønadsendringListe: List<Stønadsendring>?,
    val engangsbeløpListe: List<Engangsbeløp>?,
    val behandlingsreferanseListe: List<Behandlingsreferanse>?,
    val sporingsdata: Sporingsdata,
)

data class Sporingsdata(val correlationId: String) {
    val brukerident: String? = null

    @Suppress("unused") // brukes av jackson
    val opprettet: LocalDateTime = LocalDateTime.now()
    val opprettetAv: String? = null
}

data class Stønadsendring(
    val type: Stønadstype,
    val sak: Saksnummer,
    val skyldner: Personident,
    val kravhaver: Personident,
    val mottaker: Personident,
    val førsteIndeksreguleringsår: Int?,
    val innkreving: Innkrevingstype,
    val beslutning: Beslutningstype,
    val omgjørVedtakId: Int?,
    val eksternReferanse: String?,
    val periodeListe: List<Periode>,
)

data class Periode(
    val periode: ÅrMånedsperiode,
    val beløp: BigDecimal?,
    val valutakode: String?,
    val resultatkode: String,
    val delytelseId: String?,
)

data class Engangsbeløp(
    val type: Engangsbeløptype,
    val sak: Saksnummer,
    val skyldner: Personident,
    val kravhaver: Personident,
    val mottaker: Personident,
    val beløp: BigDecimal?,
    val valutakode: String?,
    val resultatkode: String,
    val innkreving: Innkrevingstype,
    val beslutning: Beslutningstype,
    val omgjørVedtakId: Int?,
    val referanse: String,
    val delytelseId: String?,
    val eksternReferanse: String?,
)

data class Behandlingsreferanse(
    val kilde: String,
    val referanse: String,
)
