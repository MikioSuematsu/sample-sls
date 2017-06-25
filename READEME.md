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
