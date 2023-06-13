package no.nav.bidrag.behandling.felles.dto.vedtak

interface VedtakClient {
    fun opprettVedtak(vedtakRequest: OpprettVedtakRequestDto): Int
    fun hentVedtak(vedtakId: Int): VedtakDto
}
