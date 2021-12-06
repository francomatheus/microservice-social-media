package br.com.social.media.account.adapter.input.web.annotation.validator

import br.com.social.media.account.adapter.input.web.annotation.NicknameUnique
import br.com.social.media.account.adapter.output.persistence.repository.AccountRepository
import io.micrometer.core.instrument.util.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueNicknameValidator(
    @Autowired private val accountRepository: AccountRepository
): ConstraintValidator<NicknameUnique, String> {

    override fun initialize(constraintAnnotation: NicknameUnique?) {
    }

    override fun isValid(valor: String, p1: ConstraintValidatorContext?): Boolean {
        if (StringUtils.isEmpty(valor)) return true

        val valueSearch = accountRepository.findByNickname(valor)

        return (valueSearch.isEmpty)
    }
}