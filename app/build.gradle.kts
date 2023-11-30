plugins {
    id("com.android.application")
}

android {
    namespace = "com.soundify"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.soundify"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.5.3")
    implementation("androidx.navigation:navigation-ui:2.5.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.android.volley:volley-cronet:1.2.1")
    implementation("com.squareup.picasso:picasso:2.71828")

    implementation("com.android.volley:volley:1.2.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.8.1")

    implementation("me.relex:circleindicator:2.1.6")
    implementation("javax.annotation:javax.annotation-api:1.3.2")



    implementation("com.google.code.gson:gson:2.8.6")
//    implementation ("com.spotify.android:auth:1.2.3")
//    implementation ("com.spotify.android:spotify-auth:1.2.0")

}