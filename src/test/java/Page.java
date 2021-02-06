import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Page {
    public void openSite(String value){
        open(value);
    }
    public void findText(String value){
        $(Selectors.withText(value)).should(Condition.exist);
    }
}
