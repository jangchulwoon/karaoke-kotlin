package com.karaoke.service

import com.karaoke.domain.Karaoke
import com.karaoke.extractor.KaraokeExtractor
import org.junit.jupiter.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object KaraokeParserTest : Spek({
    Feature("TJ에서 노래검색을 한다.") {
        val companyType = KaraokeCompany.TJ

        Scenario("가수 검색을 한다.") {
            val karaokeParser = KaraokeParser(KaraokeExtractor())
            var searchType = SearchType.INVALID
            var keyword = ""

            var result: List<Karaoke>? = null
            val expect: List<String> = listOf()
            Given("가수 이름으로 우원재를 검색한다") {
                searchType = SearchType.SINGER
                keyword = "우원재"
            }

            When("가수 검색을 하면") {
                result = karaokeParser.searchSong(companyType, searchType, keyword)
            }

            Then("우원재 노래가 나온다") {
                assertTrue((result?.size ?: 0)  != 0)
            }

        }

    }


})