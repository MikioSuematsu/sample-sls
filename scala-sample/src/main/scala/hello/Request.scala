package hello

import java.util.{Map => JavaMap}
import scala.collection.JavaConversions._
import scala.beans.BeanProperty

//サンプルでは、QueryString を受け取るようにしている
class HelloRequest(@BeanProperty  var queryStringParameters: JavaMap[String, String]) {
  def this() = this(Map("" -> ""))
}
