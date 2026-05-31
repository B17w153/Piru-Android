plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.b17w153.piru"
        minSdk = 21
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "latest"
    }

    packaging {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

dependencies {
    implementation platform("androidx.compose:compose-bom:2024.01.01")
    implementation "androidx.compose.material3:material3"
    implementation "androidx.compose.ui:ui"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx"
    implementation "androidx.activity:activity-compose"
    implementation "io.coil-kt:coil-compose"
    implementation "androidx.work:work-runtime-ktx"
    implementation "com.google.dagger:hilt-android"
    kapt "com.google.dagger:hilt-android-compiler"
    implementation "com.github.PhilJay:MPAndroidChart:v4.0.0"

    testImplementation "junit:junit:4.13.2"
    androidTestImplementation "androidx.test.ext:junit"
    androidTestImplementation "androidx.test.espresso:espresso-core"
    androidTestImplementation platform("androidx.compose:compose-bom:2024.01.01")
    androidTestImplementation "androidx.compose.ui:ui-test-junit4"
    debugImplementation "androidx.compose.ui:ui-tooling"
    debugImplementation "androidx.compose.ui:ui-test-manifest"
}