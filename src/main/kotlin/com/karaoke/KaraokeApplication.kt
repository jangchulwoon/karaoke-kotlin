package com.karaoke

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KaraokeApplication

//https://spring.io/guides/tutorials/spring-boot-kotlin/
fun main(args: Array<String>) {
    runApplication<KaraokeApplication>(*args)
}
