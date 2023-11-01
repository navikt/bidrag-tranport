package no.nav.bidrag.transport.behandling.vedtak

import no.nav.bidrag.domene.enums.EngangsbeløpType
import no.nav.bidrag.domene.enums.Innkreving
import no.nav.bidrag.domene.enums.StønadType
import no.nav.bidrag.domene.enums.VedtakKilde
import no.nav.bidrag.domene.enums.VedtakType
import no.nav.bidrag.domene.ident.PersonIdent
import no.nav.bidrag.domene.streng.Enhetsnummer
import no.nav.bidrag.domene.streng.Saksnummer
import no.nav.bidrag.domene.tid.Datoperiode
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class VedtakHendelse(
    val kilde: VedtakKilde,
    val type: VedtakType,
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
    val type: StønadType,
    val sak: Saksnummer,
    val skyldner: PersonIdent,
    val kravhaver: PersonIdent,
    val mottaker: PersonIdent,
    val førsteIndeksreguleringsår: Int?,
    val innkreving: Innkreving,
    val endring: Boolean,
    val omgjørVedtakId: Int?,
    val eksternReferanse: String?,
    val periodeListe: List<Periode>,
)

data class Periode(
    val periode: Datoperiode,
    val beløp: BigDecimal?,
    val valutakode: String?,
    val resultatkode: String,
    val delytelseId: String?,
)

data class Engangsbeløp(
    val type: EngangsbeløpType,
    val sak: Saksnummer,
    val skyldner: PersonIdent,
    val kravhaver: PersonIdent,
    val mottaker: PersonIdent,
    val beløp: BigDecimal?,
    val valutakode: String?,
    val resultatkode: String,
    val innkreving: Innkreving,
    val endring: Boolean,
    val omgjørVedtakId: Int?,
    val referanse: String,
    val delytelseId: String?,
    val eksternReferanse: String?,
)

data class Behandlingsreferanse(
    val kilde: String,
    val referanse: String,
)
