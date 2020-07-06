package com.karaoke.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KaraokeControllerSpec : Spek({
    describe("find Karaoke") {
        val karaoke by memoized { KaraokeController() }

        it("find Karaoke") {
            assertEquals("TJ music 우원재", karaoke.findKaraoke("TJ", "music", "우원재"))
        }
    }
})