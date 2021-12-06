package br.com.social.media.account.adapter.output.persistence

import br.com.social.media.account.adapter.output.persistence.model.AccountCreatedEntity
import br.com.social.media.account.adapter.output.persistence.repository.AccountRepository
import br.com.social.media.account.application.port.output.AccountCreatedPersistencePort
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountCreatedPersistence(
    @Autowired val accountRepository: AccountRepository
): AccountCreatedPersistencePort {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun accountCreatedPersistence(accountCreatedEntity: AccountCreatedEntity) {
        logger.info("class=AccountCreatedPersistence, function=accountCreatedPersistence, message=Init persistence account created")
        saveAccountCreated(accountCreatedEntity)
    }

    private fun saveAccountCreated(accountCreatedEntity: AccountCreatedEntity): AccountCreatedEntity {
        logger.info("class=AccountCreatedPersistence, function=saveAccountCreated, message=Init save account created")
        return accountRepository.save(accountCreatedEntity)
    }
}