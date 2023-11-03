package no.nav.bidrag.transport.behandling.beregning.felles

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.enums.Grunnlagstype
import no.nav.bidrag.domene.tid.ÅrMånedsperiode

@Schema(description = "Grunnlaget for en beregning av barnebidrag, forskudd og særtilskudd")
data class BeregnGrunnlag(
    @Schema(description = "Beregningsperiode") val periode: ÅrMånedsperiode? = null,
    @Schema(description = "Ident til søknadsbarnet") val søknadsbarnReferanse: String? = null,
    @Schema(description = "Periodisert liste over grunnlagselementer") val grunnlagListe: List<Grunnlag>? = null,
)

fun BeregnGrunnlag.valider() {
    requireNotNull(periode) { "beregningsperiode kan ikke være null" }
    requireNotNull(periode.fom) { "beregningsperiode fom kan ikke være null" }
    requireNotNull(periode.til) { "beregningsperiode til kan ikke være null" }
    requireNotNull(søknadsbarnReferanse) { "søknadsbarnIdent kan ikke være null" }
    grunnlagListe?.map { it.valider() } ?: throw IllegalArgumentException("grunnlagListe kan ikke være null")
}

data class InnholdMedNavn<T>(val navn: String, val innhold: T)

fun <T> BeregnGrunnlag.hentInnholdBasertPåNavn(
    grunnlagType: Grunnlagstype,
    clazz: Class<T>,
    navn: String = "",
): List<InnholdMedNavn<T>> = grunnlagListe!!
    .filter { it.type == grunnlagType }
    .filter { navn.isEmpty() || navn == it.navn }
    .map {
        val mapper = ObjectMapper()
        val innhold = mapper.findAndRegisterModules().readValue(it.innhold.toString(), clazz)
        InnholdMedNavn(it.navn!!, innhold)
    }

fun <T> BeregnGrunnlag.hentInnholdBasertPåReferanse(
    grunnlagType: Grunnlagstype,
    clazz: Class<T>,
    referanse: String = "",
): List<InnholdMedNavn<T>> = grunnlagListe!!
    .filter { it.type == grunnlagType }
    .filter { referanse.isEmpty() || it.grunnlagsreferanseListe!!.contains(referanse) }
    .map {
        val mapper = ObjectMapper()
        val innhold = mapper.findAndRegisterModules().readValue(it.innhold.toString(), clazz)
        InnholdMedNavn(it.navn!!, innhold)
    }

@Schema(description = "Grunnlag")
data class Grunnlag(
    @Schema(description = "Referanse (unikt navn på grunnlaget)") val navn: String? = null,
    @Schema(description = "Grunnlagstype") val type: Grunnlagstype? = null,
    @Schema(description = "Liste over grunnlagsreferanser") val grunnlagsreferanseListe: List<String>? = null,
    @Schema(description = "Grunnlagsinnhold (generisk)") val innhold: JsonNode? = null,
)

fun Grunnlag.valider() {
    requireNotNull(navn) { "navn kan ikke være null" }
    requireNotNull(type) { "type kan ikke være null" }
    requireNotNull(innhold) { "innhold kan ikke være null" }
}
