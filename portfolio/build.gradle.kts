plugins {
    hiltAndroidLib
}

android.buildFeatures.compose = true
android.composeOptions.kotlinCompilerExtensionVersion = Version.compose

dependencies {
    implementation(
        project(Project.stockDataLib),
        project(Project.coreModelLib),
        project(Project.composeCommons))

    implementation(
        Library.composeUI,
        Library.composeTooling,
        Library.composeFoundation,
        Library.composeMaterial,
        Library.composeCompiler,
        Library.composeHilt,
        Library.composeViewModel)

}
