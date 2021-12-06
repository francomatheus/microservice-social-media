package br.com.social.media.account.application.domain

import br.com.social.media.account.adapter.output.persistence.model.AccountCreatedEntity
import br.com.social.media.account.application.port.output.AccountCreatedPersistencePort
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AccountCreatedDomain (
    @field: Email
    @field: NotNull
    val email: String,
    @field: NotBlank
    val name: String,
    @field: NotBlank
    val nickname: String,
    @field: NotBlank
    val password: String,
    @field: NotBlank
    val cpf: String,
    @field: NotBlank
    val address: String,
    @field: NotBlank
    val phone: String
){
    fun createAccountEntity(): AccountCreatedEntity{
        return AccountCreatedEntity(
            email = this.email,
            name = this.name,
            nickname = this.nickname,
            password = this.password,
            cpf = this.cpf,
            address = this.address,
            phone = this.phone
        )
    }
}