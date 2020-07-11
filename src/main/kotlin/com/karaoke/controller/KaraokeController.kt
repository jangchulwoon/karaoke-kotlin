package com.karaoke.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class KaraokeController {

    @GetMapping("/{company}")
    fun findKaraoke(@PathVariable company: String, @RequestParam category: String, @RequestParam word: String) = """
        $company $category $word
    """.trimIndent()


}
