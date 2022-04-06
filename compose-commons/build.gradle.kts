plugins {
    androidLib
}

android.buildFeatures.compose = true
android.composeOptions.kotlinCompilerExtensionVersion = Version.compose

dependencies {
    implementation(
        Library.lifecycleRuntime,
        Library.composeUI,
        Library.composeCompiler,
        Library.composeTooling,
        Library.composeFoundation,
        Library.composeMaterial,
        Library.composeViewModel)
}
