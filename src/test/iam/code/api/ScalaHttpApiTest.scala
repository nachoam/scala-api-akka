package iam.code.api

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import iam.code.api.user.infraestructure.marshaller.UserMarshaller
import iam.code.api.user.infraestructure.stub.UserStub
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import spray.json._

class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest{

  "ScalaHttpApi" should {
    /**
     * This is a really dummy test because with it we're testing nothing but Akka HTTP routing system.
     * As you can see in the routesWithDefinedResponses defined above, we've already provided an implementation.
     *
     * However, this is useful to start digging a little in how Akka HTTP testkit works and so on.
     * More information: https://doc.akka.io/docs/akka-http/current/scala/http/routing-dsl/testkit.html
     */
    "respond successfully while requesting its status" in {
      Get("/status") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }
    "return pong while asking ping" in {
      Get("/ping") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"data":"pong"}"""
      }
    }
    "return all the system users" in {
      Get("/users") ~> Routes.all ~> check {
        val expectedUsers = Seq(
          UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
          UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
        )
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe UserMarshaller.marshall(expectedUsers)
      }
    }
  }
}
