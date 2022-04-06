rootProject.name = "Stock Portfolio"

pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
    }
}

include(
    ":app",
    ":remote",
    ":stock-data-lib",
    ":core-models",
    ":compose-commons",
    ":portfolio"
)
