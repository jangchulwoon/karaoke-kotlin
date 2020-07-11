package com.karaoke

import org.assertj.core.api.Assertions.fail
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KaraokeApplicationTests {

    // 얘는 테스트를 어떻게 짜지?
    @Test
    fun contextLoads() {
        runApplication<KaraokeApplication>()

    }

}
