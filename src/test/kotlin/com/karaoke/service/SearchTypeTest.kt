package com.karaoke.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object SearchTypeTest : Spek({
    Feature("{type}으로 검색한다.") {
        Scenario("번호를 이용하여 검색한다.") {
            val typeString = "number"
            var searchType:SearchType = SearchType.INVALID

            When("'number' param을 받으면"){
                searchType = SearchType.find(typeString)
            }

            Then("number Type 이 반환된다.") {
                assertEquals(SearchType.NUMBER, searchType)
            }

        }
    }

})