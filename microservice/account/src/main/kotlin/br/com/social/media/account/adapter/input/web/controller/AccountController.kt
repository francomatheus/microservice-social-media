package br.com.social.media.account.adapter.input.web.controller

import br.com.social.media.account.application.port.input.AccountCreatedUseCase
import br.com.social.media.account.adapter.input.web.model.AccountCreatedRequest
import okhttp3.Response
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/account")
class AccountController(
    @Autowired val accountCreatedUseCase: AccountCreatedUseCase
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/v1/create")
    fun createNewAccount(
        @Valid @RequestBody accountCreatedRequest: AccountCreatedRequest
    ): ResponseEntity<String> {
        logger.info("class=AccountController, function=createNewAccount, message=Init account created, nickname=${accountCreatedRequest.nickname}, email=${accountCreatedRequest.email}")

        accountCreatedUseCase.accountCreated(accountCreatedRequest)

        return ResponseEntity.status(HttpStatus.CREATED).body("Account created with success!!!")
    }
}