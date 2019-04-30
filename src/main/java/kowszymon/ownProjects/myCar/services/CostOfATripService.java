package kowszymon.ownProjects.myCar.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CostOfATripService {



    public static double getAverageLpgCost() throws IOException {
        Document document = Jsoup.connect("http://nafta.wnp.pl/ceny_paliw/").get();
        Element table = document.select("table").first();
        Elements tableRows = table.select("tr");
        boolean tableHeader = true;
        double priceSum = 0;

        for (Element tableRow: tableRows) {
            if (tableHeader) {
                tableHeader = false;
                continue;
            }

            Elements tableCols = tableRow.select("td");
            priceSum += Double.parseDouble(tableCols.get(4).html().replaceAll(" .*", "")); // Cena LPG, czyli 5 kolumna
        }

        return priceSum / (double)(tableRows.size() - 1);
    }
}
