package tv.codely.scala_bootstrap

import org.scalatest._
import org.scalatest.Matchers._

final class ScalaBootstrapTest extends WordSpec with GivenWhenThen {
  "ScalaBootstrap" should {
    "greet" in {
      Given("a ScalaBootstrap")

      val scalaBootstrap = new ScalaBootstrap

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting = scalaBootstrap.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
