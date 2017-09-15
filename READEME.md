## 事前準備

下記nodejsのサンプルをパッケージ後、
./node-sample
```
sls package --package sample
```

↓のscalaプロジェクトでコンパイル & デプロイを実行
./scala-sample
```
sbt assembly
sls deploy -v
```


MEMO
https://bramp.github.io/js-sequence-diagrams/
```
ApiGateway-->Lambda:HTTP GET 
Lambda-->Service:GET(HelloRequest)
Service->Slack:POST(meesage)
Service->>Lambda:Response
Lambda->>ApiGateway: HTTP

hogehoge
```
