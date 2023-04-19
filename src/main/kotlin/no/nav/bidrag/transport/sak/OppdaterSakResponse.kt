package no.nav.bidrag.transport.sak

import no.nav.bidrag.domain.bool.Ansatt
import no.nav.bidrag.domain.bool.Inhabilitet
import no.nav.bidrag.domain.bool.LevdeAdskilt
import no.nav.bidrag.domain.bool.Paragraf19
import no.nav.bidrag.domain.enums.Arbeidsfordeling
import no.nav.bidrag.domain.enums.Bidragssakstatus
import no.nav.bidrag.domain.enums.Konvensjon
import no.nav.bidrag.domain.enums.Sakskategori
import no.nav.bidrag.domain.string.Enhetsnummer
import no.nav.bidrag.domain.string.FfuReferansenr
import no.nav.bidrag.domain.string.Landkode
import no.nav.bidrag.domain.string.Saksnummer
import no.nav.bidrag.domain.tid.Konvensjonsdato
import no.nav.bidrag.domain.tid.SanertDato

data class OppdaterSakResponse(
    val saksnummer: Saksnummer,
    val eierfogd: Enhetsnummer,
    val kategorikode: Sakskategori,
    val status: Bidragssakstatus,
    val ansatt: Ansatt,
    val inhabilitet: Inhabilitet,
    val levdeAdskilt: LevdeAdskilt,
    val paragraf19: Paragraf19,
    val sanertDato: SanertDato?,
    val arbeidsfordeling: Arbeidsfordeling,
    val landkode: Landkode?,
    val konvensjonskode: Konvensjon?,
    val konvensjonsdato: Konvensjonsdato?,
    val ffuReferansenr: FfuReferansenr?,
    val roller: Collection<RolleDto> = setOf()
)
