package hello

import scala.beans.BeanProperty
import spray.json._
import DefaultJsonProtocol._
import scala.collection.JavaConverters._


case class Response(@BeanProperty body: String,
                    @BeanProperty headers: java.util.Map[String, String],
                    @BeanProperty statusCode: Int)

object ResponseHeaders {
  val headers = Map(
    "Content-Type" -> "application/json",
    "Access-Control-Allow-Origin" -> "*" //ブラウザ上から異なるドメインに対してアクセスする際にこのヘッダが必要
  )
}

object SucessResponse {
  def apply(message:String = "", headers: Map[String, String] = ResponseHeaders.headers, statusCode: Int = 200) = {
    val response = Map("message" -> message)
    new Response(
      response.toJson.toString, //このサンプルでは spray.json で オブジェクトを JSONに変換している
      headers.asJava,  //scalaのMapのままではAWS Lambdaで解釈できないためJavaのMapに変換が必要
      statusCode)
  }
}

object ErrorResponse {
  def apply(message:String = "", headers: Map[String, String] = ResponseHeaders.headers,  statusCode: Int = 500) = {
    val response = Map("message" -> s"サーバーでエラーが発生しました。 $message ")
    new Response(response.toJson.toString, headers.asJava, statusCode)
  }
}
