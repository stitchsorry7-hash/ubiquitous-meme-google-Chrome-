plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android { namespace = "com.example.teraboxcurrency"; compileSdk = 35
    defaultConfig { applicationId = "com.example.teraboxcurrency"; minSdk = 24; targetSdk = 35; versionCode = 1; versionName = "1.0" }
}

dependencies { implementation("androidx.core:core-ktx:1.17.0"); implementation("androidx.activity:activity-compose:1.10.1"); implementation("androidx.compose.ui:ui:1.9.0"); implementation("androidx.compose.material3:material3:1.3.2"); implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2"); testImplementation("junit:junit:4.13.2") }

