package no.nav.bidrag.transport.person

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.domene.ident.PersonIdent
import no.nav.bidrag.domene.streng.Språkkode

@Schema(
    description = "Representerer en person med tilhørende informasjon om navn, " +
        "fødselsdato, adresse, gradering, språk, dødsdato, dødsbo og tidligere identer",
)
data class PersondetaljerDto(
    val person: PersonDto,
    val adresse: PersonAdresseDto?,
    val kontonummer: KontonummerDto?,
    val dødsbo: DødsboDto?,
    val språk: Språkkode?,

    @Schema(description = "Liste over tidligere identer personen har hatt.")
    val tidligereIdenter: List<PersonIdent>?,
)
