package no.nav.bidrag.behandling.felles.dto.stonad

interface StonadClient {

    fun opprettStonad(stonadRequest: OpprettStonadRequestDto): Int

    fun hentStonadFraId(stonadId: Int): StonadDto?

    fun hentStonad(stonadType: String, skyldnerId: String, kravhaverId: String, sakId: String): StonadDto?

    fun finnAlleEndringerMottakerIdForStonad(stonadId: Int): StonadDto
}
