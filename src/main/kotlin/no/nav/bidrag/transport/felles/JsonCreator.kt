package no.nav.bidrag.transport.felles

import com.fasterxml.jackson.annotation.JsonCreator
import no.nav.bidrag.domain.bool.Ansatt
import no.nav.bidrag.domain.bool.BegrensetTilgang
import no.nav.bidrag.domain.bool.Inhabilitet
import no.nav.bidrag.domain.bool.LevdeAdskilt
import no.nav.bidrag.domain.bool.MottagerErVerge
import no.nav.bidrag.domain.bool.Paragraf19
import no.nav.bidrag.domain.ident.PersonIdent
import no.nav.bidrag.domain.ident.ReellMottager
import no.nav.bidrag.domain.ident.SamhandlerId
import no.nav.bidrag.domain.string.Enhet
import no.nav.bidrag.domain.string.FfuReferansenr
import no.nav.bidrag.domain.string.Landkode
import no.nav.bidrag.domain.string.Objektnummer
import no.nav.bidrag.domain.string.Resultat
import no.nav.bidrag.domain.string.Saksnummer
import no.nav.bidrag.domain.tid.Konvensjonsdato
import no.nav.bidrag.domain.tid.SanertDato
import java.time.LocalDate

@JsonCreator
fun Ansatt.fraVerdi(verdi: Boolean) = Ansatt(verdi)

@JsonCreator
fun BegrensetTilgang.fraVerdi(verdi: Boolean) = BegrensetTilgang(verdi)

@JsonCreator
fun Enhet.fraVerdi(verdi: String) = Enhet(verdi)

@JsonCreator
fun FfuReferansenr.fraVerdi(verdi: String) = FfuReferansenr(verdi)

@JsonCreator
fun Inhabilitet.fraVerdi(verdi: Boolean) = Inhabilitet(verdi)

@JsonCreator
fun Konvensjonsdato.fraVerdi(verdi: LocalDate) = Konvensjonsdato(verdi)

@JsonCreator
fun Landkode.fraVerdi(verdi: String) = Landkode(verdi)

@JsonCreator
fun LevdeAdskilt.fraVerdi(verdi: Boolean) = LevdeAdskilt(verdi)

@JsonCreator
fun MottagerErVerge.fraVerdi(verdi: Boolean) = MottagerErVerge(verdi)

@JsonCreator
fun Objektnummer.fraVerdi(verdi: String) = Objektnummer(verdi)

@JsonCreator
fun Paragraf19.fraVerdi(verdi: Boolean) = Paragraf19(verdi)

@JsonCreator
fun PersonIdent.fraVerdi(verdi: String) = PersonIdent(verdi)

@JsonCreator
fun ReellMottager.fraVerdi(verdi: String) = ReellMottager(verdi)

@JsonCreator
fun Resultat.fraVerdi(verdi: String) = Resultat(verdi)

@JsonCreator
fun Saksnummer.fraVerdi(verdi: String) = Saksnummer(verdi)

@JsonCreator
fun SamhandlerId.fraVerdi(verdi: String) = SamhandlerId(verdi)

@JsonCreator
fun SanertDato.fraVerdi(verdi: LocalDate) = SanertDato(verdi)
