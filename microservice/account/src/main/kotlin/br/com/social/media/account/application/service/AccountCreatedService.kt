package br.com.social.media.account.application.service

import br.com.social.media.account.adapter.input.web.model.AccountCreatedRequest
import br.com.social.media.account.application.port.input.AccountCreatedUseCase
import br.com.social.media.account.application.port.output.AccountCreatedPersistencePort
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountCreatedService(
    @Autowired val accountCreatedPersistence: AccountCreatedPersistencePort
): AccountCreatedUseCase {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun accountCreated(accountCreatedRequest: AccountCreatedRequest) {
        logger.info("class=AccountCreatedService, function=accountCreated, message=Init service account created")
        accountCreatedPersistence.accountCreatedPersistence(accountCreatedRequest.toDomain().createAccountEntity())
    }
}