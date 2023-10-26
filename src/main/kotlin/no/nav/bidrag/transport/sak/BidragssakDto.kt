package no.nav.bidrag.transport.sak

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domain.bool.BegrensetTilgang
import no.nav.bidrag.domain.bool.LevdeAdskilt
import no.nav.bidrag.domain.bool.Paragraf19
import no.nav.bidrag.domain.bool.UkjentPart
import no.nav.bidrag.domain.enums.Bidragssakstatus
import no.nav.bidrag.domain.enums.Sakskategori
import no.nav.bidrag.domain.string.Enhetsnummer
import no.nav.bidrag.domain.string.Saksnummer
import no.nav.bidrag.domain.tid.OpprettetDato

@Schema(description = "Metadata for en bidragssak")
data class BidragssakDto(
    @Schema(description = "Eierfogd for bidragssaken")
    val eierfogd: Enhetsnummer,
    @Schema(description = "Saksnummeret til bidragssaken")
    val saksnummer: Saksnummer,
    @Schema(description = "Saksstatus til bidragssaken")
    val saksstatus: Bidragssakstatus,
    @Schema(description = "Kategorikode: 'N' eller 'U'")
    val kategori: Sakskategori,
    @Schema(description = "Om saken omhandler paragraf 19")
    val erParagraf19: Paragraf19 = Paragraf19(false),
    @Schema(description = "Om saken inneholder personer med diskresjonskode")
    val begrensetTilgang: BegrensetTilgang = BegrensetTilgang(false),
    val opprettetDato: OpprettetDato,
    val levdeAdskilt: LevdeAdskilt,
    @Schema(description = "Hvor vidt en av partene i saken er ukjent")
    val ukjentPart: UkjentPart,
    @Schema(description = "Rollene som saken inneholder")
    val roller: List<RolleDto> = emptyList(),
)
