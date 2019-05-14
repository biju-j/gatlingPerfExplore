package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import scala.util.Random

class mediumtest extends Simulation {
  val httpProtocol = http
  .baseUrl("http://medium.com")
  .acceptHeader("application/json")
  .acceptLanguageHeader("en;q=1.0,de-AT;q=0.9")
  .acceptEncodingHeader("gzip;q=1.0,compress;q=0.5")
  .userAgentHeader("Safari")

  val scn = scenario("Simple Get Request")
  .exec(http("Get HTTP")
  .get("/"))

  setUp(scn.inject(atOnceUsers(100)).protocols(httpProtocol))
}