package com.karaoke.controller

import org.spekframework.spek2.Spek

object MyTest: Spek({
    println("this is the root")
    group("some group") {
        println("some group")
        test("some test") {
            println("some test")
        }
    }

    group("another group") {
        println("another group")
        test("another test") {
            println("another test")
        }
    }
})