package br.com.social.media.account.adapter.input.web.annotation

import br.com.social.media.account.adapter.input.web.annotation.validator.UniqueNicknameValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(UniqueNicknameValidator::class))
annotation class NicknameUnique(
    val message: String = "já existe este valor no banco de dados",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)
