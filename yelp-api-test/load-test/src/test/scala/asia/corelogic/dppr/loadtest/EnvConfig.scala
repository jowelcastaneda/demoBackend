package asia.corelogic.dppr.loadtest

import com.typesafe.config.{Config, ConfigFactory}

trait EnvConfig {
  private val env = System.getProperty("env", "dev-local")
  private val envConfig: Config = ConfigFactory.load(s"application-${env}.properties")

  def getConfigValue(key: String): String = envConfig.getString(key)
}