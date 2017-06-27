package hello

import org.specs2.mutable.Specification
import scala.collection.JavaConversions._
import org.specs2.specification.Scope

class ServiceSpec extends Specification {

  class Service extends ServiceInterface with MixInSlackMock  //依存性の注入
  trait context extends Scope {
      val service = new Service
  }
  "Serice test" should {
    "ビジネスロジックのテスト" in new context {
      val actual = service.get(new HelloRequest(queryStringParameters = Map("key" -> "A")), null)
      actual.statusCode must_==(200)
    }
  }
}