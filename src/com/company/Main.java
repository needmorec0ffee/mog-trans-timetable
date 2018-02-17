package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        try {
//            Document doc = Jsoup.connect("http://mogilev.gov.by/transport/raspisanie-dvizheniya-gorodskikh-avtobusov/marshrut-1.html").get();
//            System.out.println(String.format(doc.title()));
//            Elements table = doc.getElementsByClass("mostable");
//            Elements rows = table.select("tr");
//            for(Element row : rows){
//                Elements busStop = row.select("th");
//                Elements bus = row.select("td");
//                if(!busStop.text().isEmpty()) {
//                    System.out.println(String.format(busStop.text() + ": " + bus.text()));
//                }
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
            try{
                Document doc = Jsoup.connect("http://rasp.ap1mogilev.by/schedules?route=1%20%20&day=2&code=1").get();
                Elements nameHtml = doc.getElementsByClass("leads");
                System.out.println(nameHtml.get(0).text());
                Elements busStop = doc.getElementsByClass("bstop");
                Elements time = doc.getElementsByClass("time-come");
                for(int i = 0; i < busStop.size(); ++i){
                    //System.out.println(busStop.get(i).text()+": "+time.get(i).text());
                    BusStop bs = new BusStop(busStop.get(i).text(), false);
                    bs.setSchedule(time.get(i).text());
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }
}
