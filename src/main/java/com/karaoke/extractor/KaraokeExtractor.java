package com.karaoke.extractor;

import com.karaoke.domain.Karaoke;
import com.karaoke.parser.Parser;
import com.karaoke.service.SearchType;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class KaraokeExtractor {

	private static final int NUMBER_INDEX = 0;
	private static final int TITLE_INDEX = 1;
	private static final int SINGER_INDEX = 2;
	private static final int CONNECT_TIMEOUT = 5000;
	private static final int MINIMUM_CONTENTS_LENGTH = 1;

	public List<Karaoke> tryToExtract(Parser parser, SearchType searchType, String word, String page) throws IOException {
		Elements dom = fetchDOM(parser.getUrl(searchType, word, page), parser.getQuery());
		return extractKaraokes(dom);
	}

	protected List<Karaoke> extractKaraokes(Elements elements) {
		return elements.stream()
			.filter(this::hasChildElement)
			.map(this::populateKaraoke)
			.collect(Collectors.toList());
	}

	private boolean hasChildElement(Element element) {
		return element.children().size() > MINIMUM_CONTENTS_LENGTH;
	}

	private Karaoke populateKaraoke(Element e) {
		// 조금 더 우아하게
		return new Karaoke(Integer.parseInt(e.child(NUMBER_INDEX).text()),
			e.child(SINGER_INDEX).text(),
			e.child(TITLE_INDEX).text());
	}

	// if result of KY is not exist,It is occur time out ..
	// I don't know how to solve the issue. :(
	private Elements fetchDOM(String str, String docQuery) throws IOException {
		log.info(str);
		return Jsoup.connect(str).timeout(CONNECT_TIMEOUT).get().select(docQuery);
	}

}