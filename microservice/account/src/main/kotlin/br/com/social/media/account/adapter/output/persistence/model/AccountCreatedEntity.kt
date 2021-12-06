package br.com.social.media.account.adapter.output.persistence.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "accounts")
data class AccountCreatedEntity(
    @Id
    var id: String? = null,
    val email: String,
    val name: String,
    val nickname: String,
    val password: String,
    val cpf: String,
    val address: String,
    val phone: String
)
