plugins {
    id("application")
    kotlin("jvm") version "1.4.21"

    kotlin("kapt") version "1.4.21"
}

group = "son.ysy"
version = "1.0"

application{
    mainClassName="MainKt"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup.moshi:moshi:1.11.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.11.0")
}
