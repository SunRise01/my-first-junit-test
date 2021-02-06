import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends Page{
    public HomePage openHomePage(String url){
        openSite(url);
        return this;
    }
    public HomePage useSearch(String value){
        $("span[class='icon-search passive']").click();
        $("input[name='query']").setValue(value).pressEnter();
        return this;
    }


    public HomePage scrollTillVisible(String value){
        $(byText(value)).scrollTo().shouldBe(Condition.visible);
        return this;
    }
}
