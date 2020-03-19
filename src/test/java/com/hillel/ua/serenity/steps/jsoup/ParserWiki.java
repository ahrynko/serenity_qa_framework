package com.hillel.ua.serenity.steps.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class ParserWiki {

    public static List<String> parseBbcTextBlocks(final String htmlCode) {
        final Document bbcDocument = Jsoup.parse(htmlCode);
        final List<String> texts = new ArrayList<>();
        final Elements textBlocks = bbcDocument.getElementsContainingOwnText("Python");
        for (final Element textBlock : textBlocks) {
            final String text = textBlock.text();
            texts.add(text);
        }
        return texts;
    }
}
