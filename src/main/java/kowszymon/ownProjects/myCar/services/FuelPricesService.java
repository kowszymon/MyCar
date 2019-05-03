package kowszymon.ownProjects.myCar.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FuelPricesService {

    public double getAverageONPrice() throws IOException {
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
            priceSum += Double.parseDouble(tableCols.get(1).html().replaceAll(" .*", ""));
        }

        return priceSum / (double)(tableRows.size() - 1);
    }


    public double getAveragePB95Price() throws IOException {
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
            priceSum += Double.parseDouble(tableCols.get(2).html().replaceAll(" .*", ""));
        }

        return priceSum / (double)(tableRows.size() - 1);
    }

    public double getAveragePB98Price() throws IOException {
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
            priceSum += Double.parseDouble(tableCols.get(3).html().replaceAll(" .*", ""));
        }

        return priceSum / (double)(tableRows.size() - 1);
    }




    public double getAverageLPGPrice() throws IOException {
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
            priceSum += Double.parseDouble(tableCols.get(4).html().replaceAll(" .*", ""));
        }

        return priceSum / (double)(tableRows.size() - 1);
    }
}
