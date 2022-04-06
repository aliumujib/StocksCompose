plugins {
    androidApp
}

android.viewBinding.isEnabled = true
hilt.enableAggregatingTask = true
android.composeOptions.kotlinCompilerExtensionVersion = Version.compose

dependencies {
    implementation(
        project(Project.stockDataLib),
        project(Project.coreModelLib),
        project(Project.composeCommons),
        project(Project.portfolio)
    )

    implementation(
        Library.coroutines,
        Library.viewModel,
        Library.activity,
        Library.lifecycleRuntime,
        Library.composeFoundation,
        Library.composeCompiler,
        Library.recyclerView
    )

    kapt(Library.daggerHiltCompiler)

}
