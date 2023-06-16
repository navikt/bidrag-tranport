package no.nav.bidrag.transport.behandling.vedtak

import no.nav.bidrag.domain.enums.EngangsbelopType
import no.nav.bidrag.domain.enums.Innkreving
import no.nav.bidrag.domain.enums.StonadType
import no.nav.bidrag.domain.enums.VedtakKilde
import no.nav.bidrag.domain.enums.VedtakType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class VedtakHendelse(
    val kilde: VedtakKilde,
    val type: VedtakType,
    val id: Int,
    val vedtakTidspunkt: LocalDateTime,
    val enhetId: String,
    val utsattTilDato: LocalDate?,
    val opprettetAv: String,
    val opprettetAvNavn: String?,
    val opprettetTidspunkt: LocalDateTime,
    val stonadsendringListe: List<Stonadsendring>?,
    val engangsbelopListe: List<Engangsbelop>?,
    val sporingsdata: Sporingsdata
)

data class Sporingsdata(val correlationId: String) {
    val brukerident: String? = null

    @Suppress("unused") // brukes av jackson
    val opprettet: LocalDateTime = LocalDateTime.now()
    val opprettetAv: String? = null
}

data class Stonadsendring(
    val type: StonadType,
    val sakId: String,
    val skyldnerId: String,
    val kravhaverId: String,
    val mottakerId: String,
    val indeksreguleringAar: String?,
    val innkreving: Innkreving,
    val endring: Boolean,
    val omgjorVedtakId: Int?,
    val eksternReferanse: String?,
    val periodeListe: List<Periode>
)

data class Engangsbelop(
    val type: EngangsbelopType,
    val sakId: String,
    val skyldnerId: String,
    val kravhaverId: String,
    val mottakerId: String,
    val belop: BigDecimal?,
    val valutakode: String?,
    val resultatkode: String,
    val innkreving: Innkreving,
    val endring: Boolean,
    val omgjorVedtakId: Int?,
    val referanse: String,
    val delytelseId: String?,
    val eksternReferanse: String?
)

data class Periode(
    val fomDato: LocalDate,
    val tilDato: LocalDate?,
    val belop: BigDecimal?,
    val valutakode: String?,
    val resultatkode: String,
    val delytelseId: String?
)
