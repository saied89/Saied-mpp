package com.jetbrains.handson.mpp.mobile

expect fun platformName(): String

fun createApplicationScreenMessage(): String =
    "Kotlin Rocks on ${platformName()}"