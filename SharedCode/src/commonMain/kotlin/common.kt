package com.jetbrains.handson.mpp.mobile

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.URLProtocol
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable

expect fun platformName(): String

fun createApplicationScreenMessage(): String =
    "Kotlin Rocks on ${platformName()}"

private const val BASE_URL = "https://swapi.co/api/"

internal expect val ApplicationDispatcher: CoroutineDispatcher

private fun <T> callSuspendFun(call: suspend () -> (T)): Deferred<T> =
    GlobalScope.async {
        call()
    }

class ApplicationApi {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    fun getOnePerson(callback: (Person) -> Unit) = GlobalScope.launch {
        val res = client.get<Person> {
            url {
                url(BASE_URL + "people/1")
            }
        }
        launch(ApplicationDispatcher) {
            callback(res)
        }
    }

}

@Serializable
data class Person(
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val films: List<String>,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val species: List<String>,
    val starships: List<String>,
    val url: String,
    val vehicles: List<String>
)