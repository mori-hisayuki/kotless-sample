# Kotless Sample

## 環境変数
|env|value|
|---|---|
|ORG_GRADLE_PROJECT_KOTLESS_BUCKET_NAME|S3のバケット名|
|||

## 動作方法
基本はTerraformと同じ

### テストラン
デプロイ時に作成されるリソース一覧を表示できる

```bash
$ ./gradle plan
```

### デプロイ
実際にAWS上にデプロイする

```bash
$ ./gradle deploy
```

### リソース削除
デプロイしたリソースをすべて削除する

```bash
$ ./gradle destroy
```
