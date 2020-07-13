package com.karaoke.parser;

import com.karaoke.service.SearchType;

import java.io.IOException;

public interface Parser {

	String getUrl(SearchType searchType, String word, String page) throws IOException;

	String getQuery();

}