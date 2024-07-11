// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply true
    alias(libs.plugins.jetbrains.kotlin.android) apply true
    id("com.google.gms.google-services") version "4.4.2" apply true
}