# Spring Boot AI Sample

Spring Boot 4.0と最新のJava 17を使ったRESTful APIのサンプルプロジェクトです。
ユーザー管理機能と数学計算機能を提供し、ドメイン駆動設計（DDD）の原則に基づいた設計で実装されています。

## 🎯 プロジェクト概要

このプロジェクトは、以下の問題を解決することを目的としています：

- **Spring Boot 4.0の学習環境提供** - 最新のSpring Boot機能を実際のプロジェクトで体験
- **RESTful API設計のベストプラクティス習得** - 実用的なAPI設計パターンの実践
- **ドメイン駆動設計（DDD）の理解促進** - 保守性の高いアプリケーション設計の学習

## ✨ 主な機能

### ユーザー管理API
- **ユーザー一覧取得** - 登録されている全ユーザーの取得
- **ユーザー詳細取得** - IDによる特定ユーザーの情報取得
- **ユーザー検索** - 名前による部分一致検索
- **ユーザー存在確認** - HEADメソッドによる存在チェック

### 計算機能API
- **円の面積計算** - 指定した半径から円の面積を計算

### システム機能
- **ヘルスチェック** - Spring Boot Actuatorによる稼働状況確認
- **統一例外処理** - 適切なHTTPステータスコードとエラーメッセージ
- **開発者ツール** - Spring Boot DevToolsによるホットリロード

## 🚀 使い方

### 前提条件

以下のツールが必要です：

- **Java 17以上** - OpenJDKまたはOracleJDKをインストール
- **Git** - ソースコードのクローン用

### セットアップ手順

1. **リポジトリのクローン**
   ```bash
   git clone https://github.com/kai993/springboot-ai-sample.git
   cd springboot-ai-sample
   ```

2. **アプリケーションの起動**
   ```bash
   # Gradleラッパーを使用（推奨）
   ./gradlew bootRun
   ```

3. **動作確認**
   ```bash
   # ヘルスチェック
   curl http://localhost:8080/actuator/health
   ```

### API使用例

プロジェクトには[test/restclient](test/restclient)フォルダに、各APIのサンプルリクエストが用意されています。

#### ユーザーAPI
```bash
# 全ユーザー取得
curl http://localhost:8080/api/users

# 特定ユーザー取得
curl http://localhost:8080/api/users/1

# ユーザー検索
curl "http://localhost:8080/api/users/search?name=太郎"
```

#### 計算API
```bash
# 円の面積計算（半径=4の場合）
curl -X POST http://localhost:8080/api/calculator/circle_area \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -d "radius=4"
```

## 📁 プロジェクト構成

本プロジェクトは、ドメイン駆動設計（DDD）の思想に基づいた階層化アーキテクチャを採用しています：

```
src/main/java/com/example/spring_boot_ai_sample/
├── DemoApplication.java          # Spring Bootメインクラス
├── application/                  # アプリケーション層
│   └── service/                  # ユースケース実装
├── domain/                       # ドメイン層
│   ├── entity/                   # エンティティ
│   ├── repository/               # リポジトリインターフェース
│   └── valueobject/              # 値オブジェクト
├── infrastructure/               # インフラストラクチャ層
│   └── repository/               # データアクセス実装
├── presentation/                 # プレゼンテーション層
│   ├── controller/               # RESTコントローラー
│   ├── dto/                      # データ転送オブジェクト
│   └── exception/                # 例外ハンドリング
└── utility/                      # ユーティリティ
    └── calculator/               # 計算関連のユーティリティ
```

### 各層の役割

- **presentation層** - HTTP通信、JSONシリアライゼーション等の外部インターフェース
- **application層** - ビジネスユースケースの調整、トランザクション管理
- **domain層** - ビジネスロジックとルールの中核
- **infrastructure層** - データベースアクセス、外部システム連携

## 🛠 開発環境

### 使用技術

- **Java 17** - LTS版による安定した開発環境
- **Spring Boot 4.0** - 最新の機能と性能改善
- **Spring Web MVC** - RESTful APIの構築
- **Spring Boot Actuator** - 運用監視機能
- **Spring Boot DevTools** - 開発効率向上
- **Lombok** - ボイラープレートコード削減
- **Gradle 9.2.1** - ビルドツール

### 開発用コマンド

```bash
# ビルド
./gradlew build

# テスト実行
./gradlew test

# アプリケーション起動
./gradlew bootRun

# 依存関係確認
./gradlew dependencies
```

## 📝 学習のポイント

このプロジェクトから学べること：

### アーキテクチャ設計
- **レイヤードアーキテクチャ** - 関心の分離による保守性向上
- **依存性逆転** - インターフェースによる疎結合設計
- **値オブジェクト** - ドメインモデルの表現力向上

### Spring Boot 4.0の活用
- **自動設定** - 設定の簡略化とベストプラクティス適用
- **プロファイル管理** - 環境ごとの設定切り替え
- **Actuator** - 本格的な運用監視機能

### API設計
- **RESTful設計** - HTTP動詞とステータスコードの適切な使用
- **統一例外処理** - エラーレスポンスの一貫性
- **DTO変換** - レイヤー間のデータ変換パターン

