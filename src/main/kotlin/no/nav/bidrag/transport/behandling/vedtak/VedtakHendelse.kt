package no.nav.bidrag.transport.behandling.vedtak

import no.nav.bidrag.domain.enums.EngangsbeløpType
import no.nav.bidrag.domain.enums.Innkreving
import no.nav.bidrag.domain.enums.StønadType
import no.nav.bidrag.domain.enums.VedtakKilde
import no.nav.bidrag.domain.enums.VedtakType
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.string.Enhetsnummer
import no.nav.bidrag.domain.string.Landkode
import no.nav.bidrag.domain.string.Saksnummer
import no.nav.bidrag.domain.string.Valutakode
import no.nav.bidrag.domain.tid.Vedtakstidspunkt
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class VedtakHendelse(
    val kilde: VedtakKilde,
    val type: VedtakType,
    val id: Int,
    val vedtakTidspunkt: Vedtakstidspunkt,
    val enhetsnummer: Enhetsnummer,
    val innkrevingUtsattTilDato: no.nav.bidrag.domain.tid.Periode<LocalDate>?,
    val fastsattILand: Landkode?,
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

data class Engangsbeløp(
    val type: EngangsbeløpType,
    val sak: Saksnummer,
    val skyldner: PersonIdent,
    val kravhaver: PersonIdent,
    val mottaker: PersonIdent,
    val beløp: BigDecimal?,
    val valutakode: Valutakode?,
    val resultatkode: String,
    val innkreving: Innkreving,
    val endring: Boolean,
    val omgjørVedtakId: Int?,
    val referanse: String,
    val delytelseId: String?,
    val eksternReferanse: String?,
)

data class Periode(
    val fom: no.nav.bidrag.domain.tid.Periode<LocalDate>,
    val til: no.nav.bidrag.domain.tid.Periode<LocalDate>?,
    val beløp: BigDecimal?,
    val valutakode: Valutakode?,
    val resultatkode: String,
    val delytelseId: String?,
)
data class Behandlingsreferanse(
    val kilde: String,
    val referanse: String,
)
