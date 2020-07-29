import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class HTMLParser {
    private String URL;
    private String[] elementsId;
    private final String TEXT_ELEMENT;
    private final String HLINK_TAG;
    private final String HREF_ATTR;
    private final String DIV_CLASS_NAME;

    public HTMLParser() {
        URL = "https://www.wikipedia.org";
        TEXT_ELEMENT = "strong";
        HLINK_TAG = "a";
        HREF_ATTR = "href";
        DIV_CLASS_NAME = "central-featured";
    }

    public static void main(String[] args) throws IOException {
        HTMLParser hp = new HTMLParser();
        hp.parse();
    }

    private void parse() throws IOException {

        System.out.println("Ссылки для wikipedia для разных стран: \n");

        Document document = Jsoup.connect(URL).get();

        Element div_element = document.getElementsByClass(DIV_CLASS_NAME).get(0);

        for (Element el : div_element.getElementsByTag(HLINK_TAG)
        ) {
            System.out.println(el.getElementsByTag(TEXT_ELEMENT).text() + " " + el.attr(HREF_ATTR));
        }

    }
}
