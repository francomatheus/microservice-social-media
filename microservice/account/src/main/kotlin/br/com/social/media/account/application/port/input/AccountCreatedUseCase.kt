package br.com.social.media.account.application.port.input

import br.com.social.media.account.adapter.input.web.model.AccountCreatedRequest

interface AccountCreatedUseCase {

    fun accountCreated(accountCreatedRequest: AccountCreatedRequest)
}
