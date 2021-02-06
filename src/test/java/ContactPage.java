import static com.codeborne.selenide.Selenide.$;

public class ContactPage extends Page{
    public ContactPage openContactPage(String url){
        openSite(url);
        $("a[href='/contact-us']").click();
        return this;
    }
    public ContactPage setUpForms(String name, String phone, String email, String country, String text){
        $("input[id='name']").setValue(name);
        $("input[id='phone']").setValue(phone);
        $("input[id='email']").setValue(email);
        $("input[id='country']").setValue(country);
        $("textarea[name='text']").setValue(text);
        return this;
    }
    public ContactPage checkCountries(String country1, String country2, String country3){
        findText(country1);
        findText(country2);
        findText(country3);
        return this;
    }
}
