package no.nav.bidrag.transport.felles

import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.util.LinkedMultiValueMap

/**
 * Interface med metode for å konvertere et objekt til en LinkedMultiValueMap
 * En LinkedMultiValueMap kan brukes i UriComponentsBuilder med .queryParams(<linkeMultiValueMap>)
 */
interface QueryObject {
    fun toQueryParams(): LinkedMultiValueMap<String, String> {
        val writeValueAsString = objectMapper.writeValueAsString(this)
        val readValue: LinkedHashMap<String, Any?> = objectMapper.readValue(writeValueAsString)
        val queryParams = LinkedMultiValueMap<String, String>()
        readValue.filterNot { it.value == null }
            .filterNot { it.value is List<*> && (it.value as List<*>).isEmpty() }
            .forEach {
                if (it.value is List<*>) {
                    val liste = (it.value as List<*>).map { elem -> elem.toString() }
                    queryParams.addAll(it.key, liste)
                } else {
                    queryParams.add(it.key, it.value.toString())
                }
            }
        return queryParams
    }
}
