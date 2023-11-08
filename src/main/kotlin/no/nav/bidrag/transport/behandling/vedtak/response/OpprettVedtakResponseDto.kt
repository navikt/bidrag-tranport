package no.nav.bidrag.transport.behandling.vedtak.response

import io.swagger.v3.oas.annotations.media.Schema
import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import no.nav.bidrag.domene.enums.BehandlingsrefKilde
import no.nav.bidrag.domene.enums.Beslutningstype
import no.nav.bidrag.domene.enums.Engangsbeløptype
import no.nav.bidrag.domene.enums.Grunnlagstype
import no.nav.bidrag.domene.enums.Innkrevingstype
import no.nav.bidrag.domene.enums.Stønadstype
import no.nav.bidrag.domene.enums.Vedtakskilde
import no.nav.bidrag.domene.enums.Vedtakstype
import no.nav.bidrag.domene.ident.Personident
import no.nav.bidrag.domene.streng.Enhetsnummer
import no.nav.bidrag.domene.streng.Saksnummer
import no.nav.bidrag.domene.tid.ÅrMånedsperiode
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Schema
data class OpprettVedtakResponseDto(

    @Schema(description = "Unik id generert for vedtak")
    val vedtaksid: Int,

    @Schema(description = "Liste over alle referansen for engangsbeløp som inngår i vedtaket. Ligger i samme rekkefølge som i requesten")
    val engangsbeløpReferanseListe: List<String>,

)
