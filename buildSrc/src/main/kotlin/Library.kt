import org.gradle.api.Plugin

object Library {
    // AndroidX
    const val coreKtx: String = "androidx.core:core-ktx:${Version.coreKtx}"
    const val appCompat: String = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val activity = "androidx.activity:activity-ktx:${Version.activity}"
    const val recyclerView: String = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
    const val viewModel: String =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"

    // Design
    const val material: String = "com.google.android.material:material:${Version.material}"

    // DI
    const val daggerHiltAndroid: String = "com.google.dagger:hilt-android:${Version.daggerHilt}"
    const val hiltCore: String = "com.google.dagger:hilt-core:${Version.daggerHilt}"
    const val daggerHiltCompiler: String =
        "com.google.dagger:hilt-android-compiler:${Version.daggerHilt}"

    // coroutines
    const val coroutines: String =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

    // Coroutine test
    const val coroutinesTest: String =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"

    // Square
    const val okhttpLogger: String =
        "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
    const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"
    const val moshiRetrofitConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"

    // Junit
    const val junit: String = "junit:junit:${Version.junit}"

    // Mockito
    const val mockito = "org.mockito.kotlin:mockito-kotlin:${Version.mockito}"

    const val junitParams = "pl.pragmatists:JUnitParams:${Version.junitParam}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
    const val turbine = "app.cash.turbine:turbine:${Version.turbine}"

    // truth
    const val truth: String = "com.google.truth:truth:${Version.truth}"

    //mock
    const val mockK: String = "io.mockk:mockk:${Version.mockK}"

    //compose
    const val composeUI: String = "androidx.compose.ui:ui:${Version.compose}"
    const val composeTooling: String = "androidx.compose.ui:ui-tooling:${Version.compose}"
    const val composeFoundation: String = "androidx.compose.foundation:foundation:${Version.compose}"
    const val composeMaterial: String = "androidx.compose.material:material:${Version.compose}"
    const val composeViewModel: String = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.composeLifeCycle}"
    const val composeHilt: String = "androidx.hilt:hilt-navigation-compose:${Version.hiltComposeNavigation}"
    const val composeCompiler: String = "androidx.compose.compiler:compiler:${Version.compose}"

}

object Project {
    const val remote = ":remote"
    const val portfolio = ":portfolio"
    const val stockDataLib = ":stock-data-lib"
    const val composeCommons = ":compose-commons"
    const val coreModelLib = ":core-models"
}
