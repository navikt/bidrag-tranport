package person.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Representerer en person med tilhørende informasjon om navn, fødselsdato, adresse, gradering, språk, dødsdato, dødsbo og tidligere identer")
data class PersoninformasjonDto(
    val person: PersonDto,
    val adresse: PersonAdresseDto?,
    val kontonummer: KontonummerDto?,
    val dodsbo: DodsboDto?,
    val språk: String?,

    @Schema(description = "Liste over tidligere identer personen har hatt.")
    val tidligereIdenter: List<String>?
)