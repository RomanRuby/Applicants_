package cushing.component.impl.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class JsoupParserPracaBy {

    public Document getDocumentJava() throws IOException {
        return Jsoup.connect(String.valueOf(Specialization.JAVASCRIPT)).get();
    }

    public Document getDocumentJavaScript() throws IOException {

        return Jsoup.connect(String.valueOf(Specialization.JAVA)).get();
    }

    public enum Specialization {
        JAVA("https://praca.by/search/resumes/?search%5Bquery%5D=java&search%5Bquery-text-params%5D%5Bheadline%5D=1&form-submit-btn=%D0%9D%D0%B0%D0%B9%D1%82%D0%B8"),
        JAVASCRIPT("https://praca.by/search/resumes/?search%5Bquery%5D=javascript&search%5Bquery-text-params%5D%5Bheadline%5D=1&form-submit-btn=%D0%9D%D0%B0%D0%B9%D1%82%D0%B8");

        Specialization(String s) {

        }
    }

}
