package com.hillel.ua.serenity.steps.jsoup;

import com.hillel.ua.logging.Logger;
import io.restassured.RestAssured;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class HtmlParsingSteps {

    @Test
    public void parseAndPrintBbcTextBlocks() {
        RestAssured.baseURI = "https://www.bbc.com";
        final String bbcHtmlCode = RestAssured.get("/russian").asString();
        final List<String> lines = parseBbcTextBlocks(bbcHtmlCode);
        lines.forEach(line -> Logger.out.info(String.format("** [Text Block] ** %s", line)));
    }

    private List<String> parseBbcTextBlocks(final String htmlCode) {
        final Document bbcDocument = Jsoup.parse(htmlCode);
        final List<String> texts = new ArrayList<>();
        final Elements textBlocks = bbcDocument.select(".dove-item span.title-link__title-text");
        for (final Element textBlock : textBlocks) {
            final String text = textBlock.text();
            texts.add(text);
        }
        return texts;
    }
}