package plugin

import Library
import androidModule
import daggerHilt
import extensions.AndroidLib
import extensions.ProjectExtension
import implementation
import kapt
import kotlinAndroid
import kotlinKapt
import testImplementation

class AndroidLibraryPlugin : BasePlugin() {

    override val pluginConfig: PluginConfig
        get() = {
            androidModule
            kotlinAndroid
            kotlinKapt
        }

    override val libraryConfig: LibraryConfig
        get() = {
            implementation(
                Library.coroutines
            )
            testImplementation(
                Library.junit,
                Library.truth,
                Library.mockK,
                Library.junitParams,
                Library.coroutinesTest,
                Library.turbine
            )
        }

    override val extensions: Array<ProjectExtension>
        get() = arrayOf(ProjectExtension.AndroidLib)
}
