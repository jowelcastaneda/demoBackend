package asia.corelogic.dppr.loadtest

import asia.corelogic.api.access.{LoadTestCredentials, TokenCache}

class TokenConfig

object TokenSupplier {
  val config = new TokenConfig with EnvConfig
  private val tokenCache = new TokenCache(config.getConfigValue("accessUrl"),  new LoadTestCredentials(config.getConfigValue("clientSecretPairs")))

  def randomToken: String = tokenCache.getRandomToken
}
