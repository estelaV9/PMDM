// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    //Primero añadir a nivel de proyecto
    id("com.google.devtools.ksp") version "2.0.21-1.0.25" apply false
}