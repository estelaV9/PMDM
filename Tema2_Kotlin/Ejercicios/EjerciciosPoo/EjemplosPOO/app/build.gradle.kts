plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //Añadir plugin a nivel de modulo
    id("com.google.devtools.ksp") version "2.0.21-1.0.25"
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

android {
    namespace = "com.example.ejemplospoo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ejemplospoo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    /* LIBRERIAS GLIDE, aunque la documentación oficial nos
    * marca la sentencia sin parentesis la sintaxis de esta versión de gradle es necesario
    * parentesis y entre comillas dobles*/
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.dagger:dagger-compiler:2.51.1")
    ksp("com.google.dagger:dagger-compiler:2.51.1")

    /* Comando que necesita instalar plugin ksp y
    sustituye a annotation que ya no se usa en gradle kotlin
    ver documentación https://kotlinlang.org/docs/ksp-quickstart.html#add-a-processor  */
    ksp("com.github.bumptech.glide:ksp:4.16.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}