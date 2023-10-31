package no.nav.bidrag.transport.sak

import no.nav.bidrag.domene.bool.Ansatt
import no.nav.bidrag.domene.bool.Inhabilitet
import no.nav.bidrag.domene.bool.LevdeAdskilt
import no.nav.bidrag.domene.bool.Paragraf19
import no.nav.bidrag.domene.enums.Arbeidsfordeling
import no.nav.bidrag.domene.enums.Bidragssakstatus
import no.nav.bidrag.domene.enums.Konvensjon
import no.nav.bidrag.domene.enums.Sakskategori
import no.nav.bidrag.domene.streng.Enhetsnummer
import no.nav.bidrag.domene.streng.FfuReferansenr
import no.nav.bidrag.domene.streng.Landkode
import no.nav.bidrag.domene.streng.Saksnummer
import no.nav.bidrag.domene.tid.Konvensjonsdato
import no.nav.bidrag.domene.tid.SanertDato

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
    val roller: Collection<RolleDto> = setOf(),
)
