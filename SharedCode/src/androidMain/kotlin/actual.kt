package com.jetbrains.handson.mpp.mobile

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Main

actual fun platformName(): String = "Android"