package br.com.social.media.account.application.port.output

import br.com.social.media.account.adapter.output.persistence.model.AccountCreatedEntity

interface AccountCreatedPersistencePort {

    fun accountCreatedPersistence(accountCreatedEntity: AccountCreatedEntity)
}