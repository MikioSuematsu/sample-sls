package hello

import com.amazonaws.services.lambda.runtime.Context

//Sserverless.ymlで呼び出すクラス
// lambdaと1対1の関係のため、ハンドラではなく直接サービスとして扱う
// このサンプルの例では、Cake Pattern用いてテストで依存性の注入を行っている
class Service extends ServiceImpl with MixInSlackRepository

trait ServiceImpl extends UseSlackRepository {
	//メソッド名やクラスは何でも良い
	def get(input: HelloRequest, context: Context): Response = {
		val message = s" query: ${input.getQueryStringParameters}"
		slack.post(message) //実際の業務処理
		return SucessResponse.apply(message)
	}
}
