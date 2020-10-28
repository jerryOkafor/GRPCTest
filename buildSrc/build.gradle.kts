plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    jcenter()
}

object Plugins {
    object Version {
        const val kotlinGradlePlugin = "1.4.10"
        const val protoPlugin = "0.8.8"
    }

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinGradlePlugin}"
    const val protoPlugin = "com.google.protobuf:protobuf-gradle-plugin:${Version.protoPlugin}"
}



dependencies {
    implementation(Plugins.kotlinGradlePlugin)
    implementation(Plugins.protoPlugin)
}
