package com.karaoke.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KaraokeControllerSpec : Spek({

    // https://www.spekframework.org/gherkin/
    // gherkin 쓰는게 .. 나을듯?
    describe("find Karaoke") {
        beforeEachTest {

        }

        it(""){

        }

        /*
            lateinit var calculator: Calculator

            beforeEachTest {
                calculator = Calculator()
            }

            위 코드를 아래 코드로 축약 가능
         */
        val karaoke by memoized { KaraokeController() }

        it("find Karaoke") {
            assertEquals("TJ music 우원재", karaoke.findKaraoke("TJ", "music", "우원재"))
        }
    }
})