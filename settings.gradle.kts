pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Nursery Management"
include(":app")
include(":data")
include(":domain")
