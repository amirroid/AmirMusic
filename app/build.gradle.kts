@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.kotlin.compose)
//    id("com.google.devtools.ksp") version "2.2.0-2.0.2"
    kotlin("kapt")
}

android {
    namespace = "ir.amirroid.amirmusics"
    compileSdk = 36

    defaultConfig {
        applicationId = "ir.amirroid.amirmusics"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.activityCompose)

    implementation(platform(libs.composeBom))

    implementation(libs.composeUi)
    implementation(libs.composeUiGraphics)
    implementation(libs.composeUiToolingPreview)
    implementation(libs.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidxTestExtJunit)
    androidTestImplementation(libs.espressoCore)
    androidTestImplementation(platform(libs.composeBom))
    androidTestImplementation(libs.composeUiTestJunit4)
    debugImplementation(libs.composeUiTooling)
    debugImplementation(libs.composeUiTestManifest)

    implementation(libs.navigationAnimated)

    implementation(libs.exoUi)
    implementation(libs.mediaSession)
    implementation(libs.exoCore)
    implementation(libs.exoMediaSessionExt)

    implementation(libs.media)

    implementation(libs.lifecycleViewModelCompose)

    implementation("com.google.dagger:hilt-android:${libs.versions.hilt.get()}")
    kapt("com.google.dagger:hilt-compiler:${libs.versions.hilt.get()}")
    implementation(libs.hiltNavigationCompose)

    implementation(libs.coilCompose)

//    implementation("androidx.constraintlayout:constraintlayout-compose:${libs.versions.androidxConstraintLayout.get()}")

    implementation(libs.paletteKtx)

    implementation(libs.roomRuntime)
    kapt(libs.roomCompiler)
    annotationProcessor(libs.roomCompiler)
    implementation(libs.roomKtx)

    implementation(libs.lottieCompose)
}