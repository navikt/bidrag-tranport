package no.nav.bidrag.behandling.felles.dto.grunnlag

interface GrunnlagClient {

    fun opprettNyGrunnlagspakke(request: OpprettGrunnlagspakkeRequestDto): Int

    fun oppdaterGrunnlagspakke(grunnlagspakkeId: Int, request: OppdaterGrunnlagspakkeRequestDto): OppdaterGrunnlagspakkeDto?

    fun hentGrunnlagspakke(grunnlagspakkeId: Int): HentGrunnlagspakkeDto?

    fun lukkGrunnlagspakke(grunnlagspakkeId: Int): Int?
}
