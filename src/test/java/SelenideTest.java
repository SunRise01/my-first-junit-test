import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SelenideTest {
	@BeforeAll
	public static void something(){
//		Configuration.browser="edge";
		Configuration.startMaximized=true;
		Configuration.driverManagerEnabled=true;
	}
	@Test
	public void searchSystem() {
		open("https://softjourn.com/");
		$("span[class='icon-search passive']").click();
		$("input[name='query']").setValue("java").pressEnter();
		$(Selectors.withText("Cloud-Based Java Tool")).should(Condition.exist);
	}

	@Test
	public void shouldContainJava(){
		open("https://softjourn.com/");
		$(byText("Our expertise")).scrollTo().shouldBe(Condition.visible);
		$(".technologies").find(Selectors.byText("Java Development")).shouldBe(Condition.visible);
	}

	@Test public void contactUs(){
		open("https://softjourn.com/");
		$("a[href='/contact-us']").click();
		$(By.linkText("United States")).should(Condition.exist);
		$(By.linkText("Ukraine")).should(Condition.exist);
		$(By.linkText("Poland")).should(Condition.exist);
		$("input[id='name']").setValue("Serhii");
		$("input[id='phone']").setValue("+380665375916");
		$("input[id='email']").setValue("sergiygonchar00@gmail.com");
		$("input[id='country']").setValue("Ukraine");
		$("textarea[name='text']").setValue("I'm trying to test your site");
	}
}
