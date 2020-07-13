package com.karaoke.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


enum class SearchType(val type: String) {
    NUMBER("number"),
    SINGER("singer"),
    TITLE("title"),
    LYRICIST("lyricist"),
    SONGWRITER("songwirter"),
    INVALID("invalid");

    companion object {
        fun find(type: String): SearchType =
                values()
                        .asSequence()
                        .find { it.type == type }
                        ?:INVALID
    }
}

@Service
class KaraokeSearchService(@Autowired val karaokeParser: KaraokeParser){

    fun findSong(type: SearchType, keyword: String) {
        if(type == SearchType.INVALID){
            return;
        }

        karaokeParser.searchSong(KaraokeCompany.TJ,type, keyword)
    }
}