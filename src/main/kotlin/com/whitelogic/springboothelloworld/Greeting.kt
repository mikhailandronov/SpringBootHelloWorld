package com.whitelogic.springboothelloworld

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

class Greeting (val id: Int = 0, val content: String = "")

@RestController
object GreetingController{
    private const val template: String = "Hello, %s!"
    var counter: Int = 0

    @GetMapping("/greeting")
    fun greeting(
        @RequestParam(value = "name", defaultValue = "World")
        name: String?
    ): Greeting {
        return Greeting(++counter, String.format(template, name))
    }
}