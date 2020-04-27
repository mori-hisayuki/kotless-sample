package io.kotless.examples

import io.kotless.dsl.lang.http.Get

object Main {
    @Get("/")
    fun root(): String = "Hello world!"
}