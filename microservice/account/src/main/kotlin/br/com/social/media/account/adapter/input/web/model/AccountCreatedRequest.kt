package br.com.social.media.account.adapter.input.web.model

import br.com.social.media.account.adapter.input.web.annotation.EmailUnique
import br.com.social.media.account.adapter.input.web.annotation.NicknameUnique
import br.com.social.media.account.application.domain.AccountCreatedDomain
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AccountCreatedRequest(
    @field: Email
    @field: NotNull
    @field: EmailUnique
    val email: String,
    @field: NotBlank
    val name: String,
    @field: NotBlank
    @field: NicknameUnique
    val nickname: String,
    @field: NotBlank
    val password: String,
    @field: NotBlank
    @field: CPF
    val cpf: String,
    @field: NotBlank
    val address: String,
    @field: NotBlank
    val phone: String
){
    fun toDomain(): AccountCreatedDomain{
        return AccountCreatedDomain(
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