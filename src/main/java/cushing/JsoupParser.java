package cushing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupParser {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://praca.by/search/resumes/?search%5Bquery%5D=java&search%5Bquery-text-params%5D%5Bheadline%5D=1&form-submit-btn=%D0%9D%D0%B0%D0%B9%D1%82%D0%B8").get();
        Elements elementsByAttributeValueStarting = document.getElementsByClass("search-list").get(0).getElementsByAttributeValueStarting("href", "http");

        for (Element elements : elementsByAttributeValueStarting) {

            String[] parts = elements.toString().split("\"");
            System.out.println(parts[3]);

            Document document_res = Jsoup.connect(parts[3]).get();
            String string = document_res.toString();
            String[] parts_1 = string.split("<meta property=\"og:description\" content=\"");
            String[] parts_2 = parts_1[1].split("\"");
            System.out.println(parts_2[0]);
        }

    }
}
