package com.tester.console.webUI;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UITesting {

    public static Map<String,Object> result = new LinkedHashMap<>();

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

    @Test
    public static void checkButtonSearchResultWithOneWay2() throws InterruptedException {
        result.put("checkButtonSearchResultWithOneWay2",false);
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

    }

    @Test
    public static void checkTheOneWayRadioClick() throws InterruptedException {
        result.put("onewayradioClick",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement onewayradio = driver.findElement(By.id("js_searchtype_oneway"));
        onewayradio.click();
        WebElement controls_js_arrivalDateDiv = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv"));
        WebElement controls_js_arrivalDateDiv_disable = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv_disable"));
        String style1 = controls_js_arrivalDateDiv.getAttribute("style");
        String style2 = controls_js_arrivalDateDiv_disable.getAttribute("style");
        if(style1.equals("display: none;")){
               result.put("onewayradioClick",true);
        }
    }

    @Test
    public static void checkTheRoundTripRadioClick() throws InterruptedException {
        result.put("js_searchtype_roundtripClick",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement js_searchtype_roundtrip = driver.findElement(By.id("js_searchtype_roundtrip"));
        js_searchtype_roundtrip.click();
        WebElement controls_js_arrivalDateDiv = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv"));
        WebElement controls_js_arrivalDateDiv_disable = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv_disable"));
        String style1 = controls_js_arrivalDateDiv.getAttribute("style");
        String style2 = controls_js_arrivalDateDiv_disable.getAttribute("style");
        if(style2.equals("display: none;")){
            result.put("js_searchtype_roundtripClick",true);
        }
    }

    @Test
    public static void checkTheInputForCityClick() throws InterruptedException {
        result.put("fromCityClick",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.name("fromCity"));
        element.click();
        WebElement hotcity = driver.findElement(By.className("hotcity"));
        String style = hotcity.getAttribute("style");
        if(style.equals("display: block;") || StringUtils.isEmpty(style)){
            element.click();
            style = hotcity.getAttribute("style");
            if(style.equals("display: none;")){
                result.put("fromCityClick",true);
            }
        }
        element.click();
        /*# 1.xpath,通过父节点获取其哥哥节点
        print driver.find_element_by_xpath("//div[@id='D']/../div[1]").text*/
        //WebElement ele = driver.findElement(By.xpath("//input[@name='fromCity']/../div[4]/"));
        //String st = ele.getAttribute("class");
        //WebElement ele2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div/div/div/div[4]/div"));
        //WebElement element = driver.findElement(By.className("hotcity"));
        //WebElement ele2 = driver.findElement(By.xpath("//div[@class='hotcity']"));
        //WebElement ele2 = ele.findElement(By.xpath("//div[@class='hotcity']"));
    }

    @Test
    public static void checkThePlaceholderForCity() throws InterruptedException {
        result.put("fromCityPlaceholder",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.name("fromCity"));
        element.click();
        if(StringUtils.isEmpty(element.getText())){
            result.put("fromCityPlaceholder",true);
            element.click();
        }
    }

    @Test
    public static void checkTheSelectForCitySug() throws InterruptedException {
        result.put("checkTheSelectForCitySug",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.name("fromCity"));
        element.click();
        //m-hct-lst js-transition-before js-transition-after
        //WebElement ele = driver.findElement(By.cssSelector("div.m-hct-lst.js-transition-before.js-transition-after"));
        WebElement ele = driver.findElement(By.className("js-hotcitylist"));
        String city = ele.getAttribute("data-code");
        ele.click();
        String input = element.getAttribute("value");
        if(input.contains(city)){
            result.put("checkTheSelectForCitySug",true);
        }
    }

    @Test
    public static void checkTheCloseXXForCitySug() throws InterruptedException {
        result.put("checkTheCloseXXForCitySug",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.name("fromCity"));
        element.click();
        WebElement ele = driver.findElement(By.id("closeXI20"));
        ele.click();
        WebElement hotcity = driver.findElement(By.className("hotcity"));
        String style = hotcity.getAttribute("style");
        if(style.equals("display: none;")){
            result.put("checkTheCloseXXForCitySug",true);
        }
    }

    @Test
    public static void checkThePrintForCity() throws InterruptedException {
        result.put("checkThePrintForCity",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.name("fromCity"));
        element.click();
        String test = "上海";
        element.clear();
        element.sendKeys(test);
        //element.sendKeys("Keys.ENTER");
        String res = element.getAttribute("value");
        /*WebElement onewayradio = driver.findElement(By.id("js_searchtype_oneway"));
        onewayradio.click();*/
        if(res.contains(test)){
            result.put("checkThePrintForCity",true);
        }
    }

    @Test
    public static void checkTheInputForDateClick() throws InterruptedException {
        result.put("checkTheInputForDateClick",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.name("fromDate"));
        element.click();
        WebElement hotcity1 = driver.findElement(By.xpath("//input[@name='fromDate']/../../div[2]"));
        String sty = hotcity1.getAttribute("style");
        if(sty.equals("display: block;")){
            result.put("checkTheInputForDateClick",true);
        }

        /*WebElement hotcity = driver.findElement(By.className("q-datepicker-fly"));
        String style = hotcity.getAttribute("style");
        if(style.equals("display: block;") || StringUtils.isEmpty(style)){
            //Thread.sleep(2000);
            element.click();
            style = hotcity.getAttribute("style");
            if(style.equals("display: none;")){
                result.put("checkTheInputForDateClick",true);
            }
        }*/
    }

    @Test
    public static void checkTheInputFormatForDateSelect() throws InterruptedException {
        result.put("checkTheInputFormatForDateSelect",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.name("fromDate"));
        String date = element.getAttribute("value");
        if(!StringUtils.isEmpty(date)){
            List<String> da = Arrays.asList(date.split("-"));
            if(da.size() == 3){
                int a = da.get(0).length();
                int b = da.get(1).length();
                int c = da.get(2).length();
                if(a == 4 && b == 2 && c ==2){
                    result.put("checkTheInputFormatForDateSelect",true);
                }
            }
        }

    }

    @Test
    public static void checkThePlaceholderForToCity() throws InterruptedException {
        result.put("checkThePlaceholderForToCity",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        //WebElement element = driver.findElement(By.name("toCity"));
        //element.clear();
        WebElement element = driver.findElement(By.className("qcbox-placeholder"));
        String place = element.getAttribute("style");
        //WebElement ele = driver.findElement(By.className("qcbox-prefix"));
        WebElement ele = driver.findElement(By.xpath("//input[@name='toCity']/../div[2]"));
        ele.click();
        place = element.getAttribute("style");
        if(place.contains("display: none;")){
            result.put("checkThePlaceholderForToCity",true);
        }
        //get city sug
        //WebElement elem = driver.findElement(By.xpath("//input[@name='toCity']/../div[4]/div[1]"));
    }

    @Test
    public static void checkTheSugForToCity() throws InterruptedException {
        result.put("checkTheSugForToCity",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        //WebElement element = driver.findElement(By.name("toCity"));
        //WebElement element = driver.findElement(By.className("qcbox-placeholder"));
        //WebElement ele = driver.findElement(By.className("qcbox-prefix"));
        WebElement ele = driver.findElement(By.xpath("//input[@name='toCity']/../div[2]"));
        ele.click();
        WebElement elem = driver.findElement(By.xpath("//input[@name='toCity']/../div[4]/div[1]"));
        String sug = elem.getAttribute("style");
        if(sug.equals("display: block;") || StringUtils.isEmpty(sug)){
            ele.click();
            sug = elem.getAttribute("style");
            if(sug.equals("display: none;")){
                result.put("checkTheSugForToCity",true);
            }
        }
        //element.submit();
        //element.click();
        //element.sendKeys(Keys.ENTER);
    }

    @Test
    public static void checkTheCitySelectForToCity() throws InterruptedException {
        result.put("checkTheCitySelectForToCity",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.xpath("//input[@name='toCity']/../div[2]"));
        ele.click();
        //it must be clicked first ,other located
        WebElement elem = driver.findElement(By.xpath("//input[@name='toCity']/../div[4]/div[1]/div[2]/div[2]/dl[1]/dd[1]/ul[1]/li[1]/a[1]"));
        String city = elem.getAttribute("data-code");
        elem.click();
        WebElement element = driver.findElement(By.name("toCity"));
        String value = element.getAttribute("value");
        if(value.contains(city)){
            result.put("checkTheCitySelectForToCity",true);
        }
    }

    @Test
    public static void checkTheSugXXXForToCity() throws InterruptedException {
        result.put("checkTheSugXXXForToCity",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.xpath("//input[@name='toCity']/../div[2]"));
        ele.click();
        //it must be clicked first ,other located
        WebElement elem = driver.findElement(By.xpath("//input[@name='toCity']/../div[4]/div[1]/div[2]/i[1]"));
        elem.click();
        WebElement hotcityele = driver.findElement(By.xpath("//input[@name='toCity']/../div[4]/div[1]"));
        String sytle = hotcityele.getAttribute("style");
        if(sytle.equals("display: none;")){
            result.put("checkTheSugXXXForToCity",true);
        }
    }

    @Test
    public static void checkTheInputForToDateClick() throws InterruptedException {
        result.put("checkTheInputForToDateClick",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.name("toDate"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().perform();
        /*WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("xpath_of_element_to_be_invisible")));*/
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", element);
        //element.click();
        //ActionChains(driver).move_to_element(ele).move_by_offset(5,5).click().perform()
        //WebElement ele = driver.findElement(By.id("js_domestic_todate"));
        //ele.sendKeys("2020-08-07");
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", ele);
        //WebElement eleme = driver.findElement(By.cssSelector("div.controls.js_arrivalDateDiv"));
        //element.sendKeys(Keys.ENTER);
        //eleme.click();
        //WebElement hotcity = driver.findElement(By.className("q-datepicker-fly"));
        //WebElement elem = driver.findElement(By.xpath("//input[@id='js_domestic_todate']/../../div[2]"));
        /*String style = element.getAttribute("style");
        if(style.equals("display: block;") || StringUtils.isEmpty(style) || style.equals("display: none;")){
            Thread.sleep(2000);
            //element.click();
            style = element.getAttribute("style");
            if(style.equals("display: none;")){
                result.put("checkTheInputForToDateClick",true);
            }
        }*/
        WebElement js_searchtype_roundtrip = driver.findElement(By.id("js_searchtype_roundtrip"));
        js_searchtype_roundtrip.click();
        //WebElement ele = driver.findElement(By.xpath("//input[@name='toDate']/../../div[2]"));
        element.click();
        WebElement hotcity = driver.findElement(By.xpath("//input[@name='toDate']/../../div[2]"));
        String style = hotcity.getAttribute("style");
        if(style.equals("display: block;") || StringUtils.isEmpty(style)){
            //Thread.sleep(2000);
            element.click();
            style = hotcity.getAttribute("style");
            if(style.equals("display: none;")){
                result.put("checkTheInputForToDateClick",true);
            }
        }
    }

    /*@Test
    public static void checkTimeSelectForToDate() throws InterruptedException {
        result.put("checkTimeSelectForToDate",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(3000);
        WebElement js_searchtype_roundtrip = driver.findElement(By.id("js_searchtype_roundtrip"));
        js_searchtype_roundtrip.click();
        WebElement e = driver.findElement(By.xpath("//input[@name='toDate']/../../div[2]"));
        //e.sendKeys("style","display:block;");
        //WebElement time = driver.findElement(By.xpath("//input[@name='toDate']/../../div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[1]"));
        WebElement time = driver.findElement(By.xpath("//input[@name='toDate']/../../div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[1]/div[1]"));
        time.click();
    }*/

    @Test
    public static void checkSearchLinkToNewurlWithOneWay() throws InterruptedException {
        result.put("checkSearchLinkToNewurlWithOneWay",false);
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // 创建chrome浏览器驱动
        WebDriver driver= new ChromeDriver();
        // 将浏览器窗口最大化
        driver.manage().window().maximize();
        driver.get("https://www.qunar.com/");
        Thread.sleep(5000);
        WebElement buttonsearch = driver.findElement(By.className("button-search"));
        WebElement buttonSearchWithOneWay = driver.findElement(By.id("js_searchtype_oneway"));
        buttonSearchWithOneWay.click();

        //get tocity value before link
        WebElement ele = driver.findElement(By.xpath("//input[@name='toCity']/../div[2]"));
        ele.click();
        WebElement elem = driver.findElement(By.xpath("//input[@name='toCity']/../div[4]/div[1]/div[2]/div[2]/dl[1]/dd[1]/ul[1]/li[1]/a[1]"));
        String city = elem.getAttribute("data-code");
        elem.click();
        WebElement elementtocity = driver.findElement(By.name("toCity"));
        String value = elementtocity.getAttribute("value");

        //get fromcity value before link
        WebElement ele1 = driver.findElement(By.xpath("//input[@name='fromCity']/../div[2]"));
        ele1.click();
        WebElement elemFromcitySug = driver.findElement(By.xpath("//input[@name='fromCity']/../div[4]/div[1]/div[2]/div[2]/dl[1]/dd[1]/ul[1]/li[2]/a[1]"));
        String fromcity = elemFromcitySug.getAttribute("data-code");
        elemFromcitySug.click();
        WebElement elementfromCity = driver.findElement(By.name("fromCity"));
        String valuefrom = elementfromCity.getAttribute("value");

        //get fromDate value before link
        WebElement ele3 = driver.findElement(By.id("js_domestic_fromdate"));
        String valueele3 = ele3.getAttribute("value");

        buttonsearch.submit();
        Thread.sleep(5000);
        //get value after link
        //WebElement newbox = driver.findElement(By.id("J_searchBox"));
        WebElement newfromcity = driver.findElement(By.xpath("//div[@id='J_searchBox']/div/div[2]/div[1]/div[1]/div[1]/input[1]"));
        WebElement newtocity = driver.findElement(By.xpath("//div[@id='J_searchBox']/div/div[2]/div[1]/div[2]/div[1]/input[1]"));
        WebElement newfromdate = driver.findElement(By.xpath("//div[@id='J_searchBox']/div/div[2]/div[1]/div[3]/div[1]/input[1]"));
        String newfromcityvalue = newfromcity.getAttribute("value");
        String newtocityvalue = newtocity.getAttribute("value");
        String newfromdatevalue = newfromdate.getAttribute("value");
        if(value.equals(newtocityvalue) && valuefrom.equals(newfromcityvalue) && valueele3.equals(newfromdatevalue)){
            result.put("checkSearchLinkToNewurlWithOneWay",true);
        }

    }

    @Test
    public static void testing() throws InterruptedException {

        try {
            checkInterToDomesticTag();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkButtonSearchWithRoundTrip2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkButtonSearchWithOneWay2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheOneWayRadioClick();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheRoundTripRadioClick();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheInputForCityClick();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkThePlaceholderForCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheSelectForCitySug();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheCloseXXForCitySug();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkThePrintForCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheInputForDateClick();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheInputFormatForDateSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkThePlaceholderForToCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheInputForToDateClick();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheSugForToCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheCitySelectForToCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkTheSugXXXForToCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            checkSearchLinkToNewurlWithOneWay();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test result is :" + result.toString());
    }
}
