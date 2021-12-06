package br.com.social.media.account.adapter.output.persistence.repository

import br.com.social.media.account.adapter.output.persistence.model.AccountCreatedEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository: MongoRepository<AccountCreatedEntity, String> {

    fun findByEmail(email: String): Optional<AccountCreatedEntity>
    fun findByNickname(nickname: String): Optional<AccountCreatedEntity>
}