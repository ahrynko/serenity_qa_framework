package com.hillel.ua.serenity.steps.jsoup;

import com.hillel.ua.logging.Logger;
import io.restassured.RestAssured;
import java.util.List;

public class WikiSearcher extends ParserWiki {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://uk.wikipedia.org";
        final String htmlCode = RestAssured.get("/wiki/Python").asString();

        final List<String> lines = parseBbcTextBlocks(htmlCode);
        lines.forEach(line -> Logger.out.info(String.format("** [Text Block] ** %s", line)));
    }
}
