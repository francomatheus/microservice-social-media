package br.com.social.media.account.adapter.input.web.model.response

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse (
    val timestamp: LocalDateTime,
    val type: String?,
    val data: List<String>? = null,
    val status: HttpStatus?= null,
    val message: String?
)
