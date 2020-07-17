package com.karaoke.controller

import com.karaoke.service.KaraokeCompany
import com.karaoke.service.KaraokeSearchService
import com.karaoke.service.SearchType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class KaraokeController(@Autowired val karaokeSearchService: KaraokeSearchService) {


    @GetMapping("/{company}")
    fun findKaraoke(@PathVariable company: String, @RequestParam category: String, @RequestParam word: String) =
            karaokeSearchService.findSong(KaraokeCompany.find(company),SearchType.find(category),word)


}
