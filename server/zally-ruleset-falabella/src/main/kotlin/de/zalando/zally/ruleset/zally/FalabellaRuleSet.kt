package de.zalando.zally.ruleset.zally

import de.zalando.zally.core.AbstractRuleSet
import de.zalando.zally.rule.api.Rule
import java.net.URI

class FalabellaRuleSet : AbstractRuleSet() {

    override val id = "F"

    override val url: URI = URI.create("https://github.com/loretop/zally/blob/master/server/rules-falabella.md")

}
