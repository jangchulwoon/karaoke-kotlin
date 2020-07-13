package com.karaoke.service

import com.karaoke.domain.Karaoke
import com.karaoke.extractor.KaraokeExtractor
import com.karaoke.parser.TJParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

enum class KaraokeCompany(val companyName: String) {
    TJ("TJ"),
    KY("KY"),
    INVALID("Invalid");

    companion object {
        fun find(companyName: String): KaraokeCompany =
                values()
                        .asSequence()
                        .find { it.companyName == companyName }
                        ?: INVALID
    }
}


@Service
class KaraokeParser(@Autowired val extractor:KaraokeExtractor) {
    fun searchSong(company: KaraokeCompany, type: SearchType, keyword: String): List<Karaoke> {
        if (KaraokeCompany.INVALID == company) {
            return listOf()
        }

        return extractor.tryToExtract(TJParser(), type, keyword, "1")

    }


}