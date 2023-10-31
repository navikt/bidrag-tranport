package no.nav.bidrag.transport.sak

import no.nav.bidrag.domene.bool.Ansatt
import no.nav.bidrag.domene.bool.Inhabilitet
import no.nav.bidrag.domene.bool.LevdeAdskilt
import no.nav.bidrag.domene.bool.Paragraf19
import no.nav.bidrag.domene.enums.Arbeidsfordeling
import no.nav.bidrag.domene.enums.Bidragssakstatus
import no.nav.bidrag.domene.enums.Konvensjon
import no.nav.bidrag.domene.enums.Sakskategori
import no.nav.bidrag.domene.string.FfuReferansenr
import no.nav.bidrag.domene.string.Landkode
import no.nav.bidrag.domene.string.Saksnummer
import no.nav.bidrag.domene.tid.Konvensjonsdato
import no.nav.bidrag.domene.tid.SanertDato

data class OppdaterSakRequest(
    val saksnummer: Saksnummer,
    val status: Bidragssakstatus? = null,
    val ansatt: Ansatt? = null,
    val inhabilitet: Inhabilitet? = null,
    val levdeAdskilt: LevdeAdskilt? = null,
    val paragraf19: Paragraf19? = null,
    val sanertDato: SanertDato? = null,
    val arbeidsfordeling: Arbeidsfordeling? = null,
    val kategorikode: Sakskategori? = null,
    val landkode: Landkode? = null,
    val konvensjonskode: Konvensjon? = null,
    val konvensjonsdato: Konvensjonsdato? = null,
    val ffuReferansenr: FfuReferansenr? = null,
    val roller: Set<RolleDto> = setOf(),
)
