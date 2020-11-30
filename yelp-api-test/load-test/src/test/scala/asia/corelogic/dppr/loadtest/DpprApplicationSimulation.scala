package asia.corelogic.dppr.loadtest

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ChainBuilder


class DpprApplicationSimulation extends Simulation with EnvConfig {

  private val httpProtocol = http.baseUrl(getConfigValue("testApplicationUrl"))
    .authorizationHeader(_ => TokenSupplier.randomToken)

  object AppStatus {
    val status: ChainBuilder = exec(http("""Status Service""")
      .get("""/private/status""")).pause(30)
  }

  object AppHealth {
    val health: ChainBuilder = exec(http("""Health Service""")
      .get("""/env/health"""))
  }

  private val appStatusScenario = scenario("Status Check").exec(AppStatus.status)
  private val appHealthScenario = scenario("Health").exec(AppHealth.health)

  setUp(
    appStatusScenario.inject(rampUsersPerSec(1) to 3 during(30 seconds)),
    appHealthScenario.inject(rampUsersPerSec(1) to 3 during(30 seconds))
  ).protocols(httpProtocol)
}