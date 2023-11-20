package no.nav.bidrag.transport.sak

import no.nav.bidrag.domene.enums.sak.Arbeidsfordeling
import no.nav.bidrag.domene.enums.sak.Bidragssakstatus
import no.nav.bidrag.domene.enums.sak.Konvensjon
import no.nav.bidrag.domene.enums.sak.Sakskategori
import no.nav.bidrag.domene.land.Landkode
import no.nav.bidrag.domene.sak.Saksnummer
import no.nav.bidrag.domene.sak.bool.LevdeAdskilt
import no.nav.bidrag.domene.sak.bool.Paragraf19
import java.time.LocalDate

data class OppdaterSakRequest(
    val saksnummer: Saksnummer,
    val status: Bidragssakstatus? = null,
    val ansatt: Boolean? = null,
    val inhabilitet: Boolean? = null,
    val levdeAdskilt: LevdeAdskilt? = null,
    val paragraf19: Paragraf19? = null,
    val sanertDato: LocalDate? = null,
    val arbeidsfordeling: Arbeidsfordeling? = null,
    val kategorikode: Sakskategori? = null,
    val landkode: Landkode? = null,
    val konvensjonskode: Konvensjon? = null,
    val konvensjonsdato: LocalDate? = null,
    val ffuReferansenr: String? = null,
    val roller: Set<RolleDto> = setOf(),
)
