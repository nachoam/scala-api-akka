package iam.code.api.user.infraestructure.stub

import iam.code.api.shared.infrastructure.stub.UuidStub
import iam.code.api.user.domain.UserId

import java.util.UUID

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
