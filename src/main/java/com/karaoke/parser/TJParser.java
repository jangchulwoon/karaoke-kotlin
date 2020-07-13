package com.karaoke.parser;

import com.karaoke.service.SearchType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TJParser implements Parser {

	private static final String URL = "https://www.tjmedia.co.kr/tjsong/song_search_list.asp?";
	private static final String DOC_QUERY = "table.board_type1 tr:has(td)";
	private static final Map<SearchType, String> URLQuery = new HashMap<>();

	static {
		URLQuery.put(SearchType.SINGER, "strType=2");
		URLQuery.put(SearchType.TITLE, "strType=1");
		URLQuery.put(SearchType.NUMBER, "strType=16");
	}

	@Override
	public String getUrl(SearchType searchType, String word, String page) throws IOException {
		return new StringBuilder(URL)
			.append(URLQuery.get(searchType))
			.append("&strText=")
			.append(word)
			.append("&strSize02=10")
			.append("&intPage=")
			.append(page).toString();
	}

	@Override
	public String getQuery() {
		return DOC_QUERY;
	}
}
