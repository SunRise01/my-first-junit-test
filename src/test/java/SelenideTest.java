import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

public class SelenideTest {
	@Test
	public void searchSystem() {
		open("https://softjourn.com/");
		$("span[class='icon-search passive']").click();
		$("input[name='query']").setValue("java1").pressEnter();
	}

	@Test
	public void shouldContainJava(){
		open("https://softjourn.com/");
		$(By.linkText("Java Development")).exists();
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
