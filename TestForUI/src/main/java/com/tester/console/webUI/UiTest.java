package com.tester.console.webUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UiTest {

    //public static Map<String,Object> result = new ConcurrentHashMap<>();
    public static Map<String,Object> result = new LinkedHashMap<>();

    public static Boolean checkTheInputForCityClick(WebElement element,WebDriver driver){
        element.click();
        WebElement hotcity = driver.findElement(By.className("hotcity"));
        String style = hotcity.getAttribute("style");
        if(style.equals("display: block;")){
            element.click();
            style = hotcity.getAttribute("style");
            if(style.equals("display: none;")){
                return true;
            }
        }
        element.click();
        return false;
    }

    public static Boolean checkTheInputForDateClick(WebElement element,WebDriver driver) throws InterruptedException {
        element.click();
        WebElement hotcity = driver.findElement(By.className("q-datepicker-fly"));
        String style = hotcity.getAttribute("style");
        if(style.equals("display: block;")){
            Thread.sleep(2000);
            element.click();
            style = hotcity.getAttribute("style");
            if(style.equals("display: none;")){
                return true;
            }
        }
        return false;
    }

    public static boolean checkTheInputForCityPrint(WebElement element,WebDriver driver){
        String test = "深圳";
        element.clear();
        element.sendKeys(test);
        String res = element.getAttribute("value");
        if(test.equals(res)){
            return true;
        }
        return false;
    }

    public static boolean checkTheInputForCityDelete(WebElement element,WebDriver driver){
        element.clear();
        String res = element.getAttribute("value");
        if(StringUtils.isEmpty(res)){
            return true;
        }
        return false;
    }

    public static boolean checkTheInputForDateDelete(WebElement element,WebDriver driver){
        element.clear();
        String res = element.getAttribute("value");
        if(StringUtils.isEmpty(res)){
            return true;
        }
        return false;
    }

    public static boolean checkTheInputForDatePrint(WebElement element,WebDriver driver){
        String test = "2020-01-01";
        element.clear();
        element.sendKeys(test);
        String res = element.getAttribute("value");
        if(test.equals(res)){
            return true;
        }
        return false;
    }

    public static boolean checkTheOneWayRadioClick(WebElement element,WebDriver driver){
        element.click();
        /*WebElement fromDate = driver.findElement(By.name("fromDate"));
        WebElement toDate = driver.findElement(By.name("toDate"));
        String fdate = fromDate.getText();
        String tdate = toDate.getText();
        if(!StringUtils.isEmpty(fdate) && StringUtils.isEmpty(tdate)){
            return true;
        }*/
        WebElement controls_js_arrivalDateDiv = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv"));
        WebElement controls_js_arrivalDateDiv_disable = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv_disable"));
        String style1 = controls_js_arrivalDateDiv.getAttribute("style");
        String style2 = controls_js_arrivalDateDiv_disable.getAttribute("style");
        if(style1.equals("display: none;")){
            return true;
        }
        return false;
    }

    public static boolean checkTheRoundTripRadioClick(WebElement element,WebDriver driver){
        element.click();
        /*WebElement fromDate = driver.findElement(By.name("fromDate"));
        WebElement toDate = driver.findElement(By.name("toDate"));
        String fdate = fromDate.getText();
        String tdate = toDate.getText();
        if(!StringUtils.isEmpty(fdate) && !StringUtils.isEmpty(tdate)){
            return true;
        }*/
        WebElement controls_js_arrivalDateDiv = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv"));
        WebElement controls_js_arrivalDateDiv_disable = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv_disable"));
        String style1 = controls_js_arrivalDateDiv.getAttribute("style");
        String style2 = controls_js_arrivalDateDiv_disable.getAttribute("style");
        if(style2.equals("display: none;")){
            return true;
        }
        return false;
    }

    public static boolean checkButtonSearchWithOneWay(WebElement element,WebDriver driver) throws InterruptedException {
        WebElement js_searchtype_oneway = driver.findElement(By.id("js_searchtype_oneway"));
        js_searchtype_oneway.click();
        element.submit();
        String loc = driver.getCurrentUrl();
        if(loc.startsWith("https://flight.qunar.com/site/oneway_list.htm") || loc.startsWith("https://flight.qunar.com/fuzzy/country_oneway.htm")){
            Thread.sleep(1000);
            driver.navigate().back();
            return true;
        }
        return false;
    }

    public static void checkButtonSearchWithOneWay2() throws InterruptedException {
        result.put("buttonSearchWithOneWay",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        Boolean buttonSearchWithRoundTrip = false;
        WebElement buttonsearch = driver.findElement(By.className("button-search"));
        WebElement buttonSearchWithOneWay = driver.findElement(By.id("js_searchtype_oneway"));
        buttonSearchWithOneWay.click();
        buttonsearch.submit();
        String loc = driver.getCurrentUrl();
        if(loc.startsWith("https://flight.qunar.com/site/oneway_list.htm") || loc.startsWith("https://flight.qunar.com/fuzzy/country_oneway.htm")){
            //Thread.sleep(1000);
            result.put("buttonSearchWithOneWay",true);
        }
    }

    public static boolean checkButtonSearchWithRoundTrip(WebElement element,WebDriver driver) {
        WebElement js_searchtype_roundtrip = driver.findElement(By.id("js_searchtype_roundtrip"));
        js_searchtype_roundtrip.click();
        element.submit();
        String loc = driver.getCurrentUrl();
        if(loc.startsWith("https://flight.qunar.com/site/roundtrip_list_new.htm") || loc.startsWith("https://flight.qunar.com/fuzzy/country_roundtrip.htm")){
            //Thread.sleep(1000);
            driver.navigate().back();
            return true;
        }
        return false;
    }

    @Test
    public static void checkButtonSearchWithRoundTrip2() throws InterruptedException {
        result.put("buttonSearchWithRoundTrip",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        Boolean buttonSearchWithRoundTrip = false;
        WebElement buttonsearch = driver.findElement(By.className("button-search"));
        WebElement js_searchtype_roundtrip = driver.findElement(By.id("js_searchtype_roundtrip"));
        js_searchtype_roundtrip.click();
        buttonsearch.submit();
        String loc = driver.getCurrentUrl();
        if(loc.startsWith("https://flight.qunar.com/site/roundtrip_list_new.htm") || loc.startsWith("https://flight.qunar.com/fuzzy/country_roundtrip.htm")){
            //Thread.sleep(1000);
            result.put("buttonSearchWithRoundTrip",true);
        }
    }

    @Test
    public static void checkInterToDomesticTag() throws InterruptedException {
        result.put("interToDomesticTag",false);
        Thread.sleep(3000);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Boolean interToDomesticTag = false;
        WebElement js_domestic_tab = driver.findElement(By.id("js_domestic_tab"));
        WebElement js_inter_tab = driver.findElement(By.id("js_inter_tab"));
        js_inter_tab.click();
        js_domestic_tab.click();
        String dstyle = js_domestic_tab.getAttribute("class");
        String istyle = js_inter_tab.getAttribute("class");
        if(dstyle.equals("cur") && StringUtils.isEmpty(istyle)){
            result.put("interToDomesticTag",true);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        // 将浏览器窗口设置成指定大小Ò
        //driver.manage().window().setSize(new Dimension(1270, 720));
        //driver.findElement(By.id("su")).click();
        Thread.sleep(5000);
        Boolean fromCityClick = false;
        Boolean fromDateClick = false;
        Boolean toCityClick = false;
        Boolean toDateClick = false;
        Boolean fromCityInput = false;
        Boolean fromCityDelete = false;
        Boolean fromDateInput = false;
        Boolean fromDateDelete = false;
        Boolean onewayradioClick = false;
        Boolean js_searchtype_roundtripClick = false;
        Boolean buttonSearchWithOneWay = false;
        Boolean buttonSearchWithRoundTrip = false;

        WebElement fromCity = driver.findElement(By.name("fromCity"));

        WebElement fromDate = driver.findElement(By.name("fromDate"));
        //WebElement toCity = driver.findElement(By.name("toCity"));
        WebElement toCity = driver.findElement(By.className("qcbox-placeholder"));
        WebElement toDate = driver.findElement(By.name("toDate"));
        WebElement buttonsearch = driver.findElement(By.className("button-search"));
        WebElement onewayradio = driver.findElement(By.id("js_searchtype_oneway"));
        WebElement js_searchtype_roundtrip = driver.findElement(By.id("js_searchtype_roundtrip"));


        try {
            fromCityClick = checkTheInputForCityClick(fromCity,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fromCityInput = checkTheInputForCityPrint(fromCity,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);

        try {
            fromDateClick = checkTheInputForDateClick(fromDate,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);

        try {
            toCityClick = checkTheInputForCityClick(toCity,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);

        try {
            toDateClick = checkTheInputForDateClick(toDate,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);

        try {
            fromCityDelete = checkTheInputForCityDelete(fromCity,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fromDateDelete = checkTheInputForDateDelete(fromDate,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fromDateInput = checkTheInputForDatePrint(fromDate,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            onewayradioClick = checkTheOneWayRadioClick(onewayradio,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            js_searchtype_roundtripClick = checkTheRoundTripRadioClick(js_searchtype_roundtrip,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            buttonSearchWithOneWay = checkButtonSearchWithOneWay(buttonsearch,driver);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*try {
            buttonSearchWithRoundTrip = checkButtonSearchWithRoundTrip(buttonsearch,driver);
        } catch (Exception e) {
        e.printStackTrace();
        }*/

        try {
            checkButtonSearchWithOneWay2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            checkButtonSearchWithRoundTrip2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            checkInterToDomesticTag();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result.put("fromDateClick",fromDateClick);
        result.put("toCityClick",toCityClick);
        result.put("toDateClick",toDateClick);
        result.put("fromCityInput",fromCityInput);
        result.put("fromCityDelete",fromCityDelete);
        result.put("fromDateDelete",fromDateDelete);
        result.put("fromDateInput",fromDateInput);
        result.put("onewayradioClick",onewayradioClick);
        result.put("js_searchtype_roundtripClick",js_searchtype_roundtripClick);
        //result.put("buttonSearchWithOneWay",buttonSearchWithOneWay);
        //result.put("buttonSearchWithRoundTrip",buttonSearchWithRoundTrip);
        System.out.println("test reslut is :" + result.toString());


        //checkTheInputForDateClick(toDate,driver);
        /*System.out.println("test is :" + checkTheInputForCityClick(fromCity,driver));
        System.out.println("test is :" + checkTheInputForDateClick(fromDate,driver));
        System.out.println("test is :" + checkTheInputForCityClick(toCity,driver));
        System.out.println("test is :" + checkTheInputForDateClick(fromDate,driver));*/
    }
}
