import io.kotless.plugin.gradle.dsl.kotless

plugins {
    kotlin("jvm") version "1.3.72"
    id("io.kotless") version "0.1.3" apply true
}

group = "io.kotless.examples"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.kotless", "lang", "0.1.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

kotless {
    config {
        //build後のモジュールとTerraformのstateファイルを配置するためのBucket
        bucket = project.property("KOTLESS_BUCKET_NAME").toString()
        //作成したリソースにつくprefix
        prefix = "dev"

        // terraformの設定
        terraform {
            // AWS CLIのcredentiaで設定したProfile
            profile = "kotless"
            // リソースの構築先リージョン（S3のリージョンと合わせる）
            region = "ap-northeast-1"
        }
    }

    //webApplicationの設定
    webapp {
        //作成するlambdaのメモリとTimeout設定
        lambda {
            memoryMb = 1024
            timeoutSec = 120
        }
    }

    extensions {
        terraform {
            //Enable back Destroy task
            allowDestroy = true
        }
    }
}