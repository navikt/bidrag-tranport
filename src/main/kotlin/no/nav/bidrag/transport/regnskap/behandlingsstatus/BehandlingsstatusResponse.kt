package no.nav.bidrag.transport.regnskap.behandlingsstatus

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.regnskap.behandlingsstatus.Batchstatus

@Schema(name = "Behandlingstatus response", description = "Response fra kall mot behandlingsstatus med batch-uid.")
data class BehandlingsstatusResponse(
    val konteringFeil: List<Feilmelding>,
    val batchStatus: Batchstatus,
    val batchUid: String,
    val totaltAntall: Int,
    val mislyketAntall: Int,
    val fullfoertAntall: Int,
)
