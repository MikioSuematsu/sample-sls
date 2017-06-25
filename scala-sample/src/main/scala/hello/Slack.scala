package hello

trait SlackRepository {def post(message: String): Unit}
trait UseSlackRepository {def slack: SlackRepository}
trait MixInSlackRepository {var slack = Slack}
trait MixInSlackMock {var slack = SlackMock}
object Slack extends SlackRepository {
  def post(message: String):Unit = println(s"【実際に SlackにPOST $message")
}
object SlackMock extends SlackRepository { //テスト用のモックを用意
def post(message: String):Unit = println(s"【SlackにPOSTしていません $message")
}