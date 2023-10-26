package no.nav.bidrag.transport.sak

import no.nav.bidrag.domain.bool.Ansatt
import no.nav.bidrag.domain.bool.Inhabilitet
import no.nav.bidrag.domain.bool.LevdeAdskilt
import no.nav.bidrag.domain.bool.Paragraf19
import no.nav.bidrag.domain.enums.Arbeidsfordeling
import no.nav.bidrag.domain.enums.Bidragssakstatus
import no.nav.bidrag.domain.enums.Konvensjon
import no.nav.bidrag.domain.enums.Sakskategori
import no.nav.bidrag.domain.string.FfuReferansenr
import no.nav.bidrag.domain.string.Landkode
import no.nav.bidrag.domain.string.Saksnummer
import no.nav.bidrag.domain.tid.Konvensjonsdato
import no.nav.bidrag.domain.tid.SanertDato

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
