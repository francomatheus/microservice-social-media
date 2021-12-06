package br.com.social.media.account.adapter.input.web.annotation.validator

import br.com.social.media.account.adapter.input.web.annotation.EmailUnique
import br.com.social.media.account.adapter.output.persistence.repository.AccountRepository
import io.micrometer.core.instrument.util.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Component
class UniqueEmailValidator(
    @Autowired private val accountRepository: AccountRepository
): ConstraintValidator<EmailUnique, String> {

    override fun initialize(constraintAnnotation: EmailUnique?) {
//        if (constraintAnnotation != null) {
//            fieldName = constraintAnnotation.fieldName
//            className = constraintAnnotation.className
//        }
    }

    override fun isValid(valor: String, p1: ConstraintValidatorContext?): Boolean {
        if (StringUtils.isEmpty(valor)) return true

        val valueSearch = accountRepository.findByEmail(valor)

        return (valueSearch.isEmpty)
    }
}