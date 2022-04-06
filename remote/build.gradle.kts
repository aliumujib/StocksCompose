import BuildType.Companion.Debug

plugins {
    hiltAndroidLib
}

android {
    defaultConfig {
        buildConfigField(
            type = "String",
            name = "BASE_URL",
            value = "\"https://storage.googleapis.com/cash-homework/\""
        )
    }

    buildTypes {
        named(Debug.name) {
            isMinifyEnabled = Debug.isMinifyEnabled
        }
    }
}

dependencies {
    implementation(
        Library.okhttpLogger,
        Library.moshi,
        Library.moshiRetrofitConverter,
        Library.retrofit,
        Library.okhttpLogger
    )

    implementation(
        project(Project.coreModelLib)
    )

    testImplementation(Library.mockWebServer)

    kapt(Library.moshiCodeGen)
}
