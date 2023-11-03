package no.nav.bidrag.transport.behandling.felles.grunnlag

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.Bostatuskode
import no.nav.bidrag.domene.enums.SivilstandskodeBeregning
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.tid.Datoperiode
import no.nav.bidrag.domene.tid.Fødselsdato
import java.time.LocalDate

@Schema(description = "Informasjon om en person som er inkludert i vedtaket")
data class Person(
    @Schema(description = "Ident") val ident: Personident = Personident(""),
    @Schema(description = "Navn") val navn: String = "",
    @Schema(description = "Fødselsdato") val fødselsdato: Fødselsdato = Fødselsdato(LocalDate.parse("2000-01-01")),
)

@Schema(description = "Bostatus for person")
data class BostatusPeriode(
    @Schema(description = "Periode") val periode: Datoperiode,
    @Schema(description = "Bostatus") val bostatus: Bostatuskode,
    @Schema(description = "Er registrert manuelt?") val manueltRegistrert: Boolean,
)

@Schema(description = "Sivilstand for person")
data class SivilstandPeriode(
    @Schema(description = "Periode") val periode: Datoperiode,
    @Schema(description = "Sivilstand") val sivilstand: SivilstandskodeBeregning,
)
