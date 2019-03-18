package com.mitrais.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        String url = "http://www.statistics.bet3000.com/s4/?clientid=193#2_1,3_1,22_1,5_54571," +
                "9_summary";

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage page = webClient.getPage(url);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.waitForBackgroundJavaScript(3000);

        List<HtmlTableDataCell> teams = (List) page.getByXPath("//td[@class='team']");
        teams.forEach(team -> System.out.println(team.getTextContent().trim()));
    }
}
