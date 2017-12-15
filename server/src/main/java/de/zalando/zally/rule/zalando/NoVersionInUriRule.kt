package de.zalando.zally.rule.zalando

import de.zalando.zally.rule.AbstractRule
import de.zalando.zally.rule.api.Check
import de.zalando.zally.rule.api.Severity
import de.zalando.zally.rule.api.Violation
import de.zalando.zally.util.PatternUtil
import io.swagger.models.Swagger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class NoVersionInUriRule(@Autowired ruleSet: ZalandoRuleSet) : AbstractRule(ruleSet) {
    override val title = "Do Not Use URI Versioning"
    override val id = "115"
    override val severity = Severity.MUST
    private val description = "basePath attribute contains version number"

    @Check(severity = Severity.MUST)
    fun validate(swagger: Swagger): Violation? {
        val hasVersion = swagger.basePath != null && PatternUtil.hasVersionInUrl(swagger.basePath)
        return if (hasVersion) Violation(description, emptyList()) else null
    }
}