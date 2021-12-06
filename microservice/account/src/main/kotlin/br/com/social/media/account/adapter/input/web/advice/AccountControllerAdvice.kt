package br.com.social.media.account.adapter.input.web.advice

import br.com.social.media.account.adapter.input.web.model.response.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class AccountControllerAdvice {

    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun accountCreatedArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse>{
        logger.info("class=AccountControllerAdvice, function=accountCreatedException, message=Error Exception, e=${e.javaClass}")

        val errors = ArrayList<String>()

        e.bindingResult.fieldErrors.stream().forEach { errors.add(" ${it.field}: ${it.defaultMessage}") }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(
            type = "Bad_request",
            message = e.message,
            data = errors,
            timestamp = LocalDateTime.now(),
            status = HttpStatus.BAD_REQUEST
        ))
    }
    @ExceptionHandler(Exception::class)
    fun accountCreatedException(e: Exception): ResponseEntity<ErrorResponse>{
        logger.info("class=AccountControllerAdvice, function=accountCreatedException, message=Error Exception, e=${e.javaClass}")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(
            type = "Bad_request",
            message = e.message,
            timestamp = LocalDateTime.now()
        ))
    }
}