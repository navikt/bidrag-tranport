package no.nav.bidrag.transport.behandling.beregning.felles.grunnlag

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.InntektRapportering
import no.nav.bidrag.domene.tid.ÅrMånedsperiode
import java.math.BigDecimal

@Schema(description = "Inntekt for person")
data class InntektRapporteringPeriode(
    @Schema(description = "Periode") val periode: ÅrMånedsperiode,
    @Schema(description = "Type inntektrapportering") val inntektRapportering: InntektRapportering,
    @Schema(description = "Referanse til barnet inntekten gjelder for") val gjelderBarn: String? = null,
    @Schema(description = "Inntekt beløp") val beløp: BigDecimal,
    @Schema(description = "Er registrert manuelt?") val manueltRegistrert: Boolean,
    @Schema(description = "Skal være del av beregning?") val valgt: Boolean,
)
