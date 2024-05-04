pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "compose"
include(":unit1-birthday")
include(":unit2-composearticle")
include(":unit2-taskcompleted")
include(":unit2-composequadrant")
include(":unit2-diceroller")
include(":unit2-tipcalculator")
include(":unit3-affirmations")
include(":unit3-courses")
include(":unit3-woof")
include(":unit4-dessert-clicker")
include(":unit4-unscramble")
include(":unit4-cupcake")
include(":unit5-race-tracker")
include(":unit5-mars-photos")
include(":unit6-inventory-app")
include(":unit7-workmanager")
