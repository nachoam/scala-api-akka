package iam.code.api.user.infraestructure.stub

import iam.code.api.shared.infrastructure.stub.{IntStub, StringStub}
import iam.code.api.user.domain.UserName

object UserNameStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): UserName = UserName(value)

  def random: UserName = UserName(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
