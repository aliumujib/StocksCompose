plugins {
    hiltAndroidLib
}

dependencies {
    implementation(project(Project.remote))
    implementation(project(Project.coreModelLib))
}
