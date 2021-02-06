import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import java.util.stream.Stream;

public class SelenideTest {
	@BeforeAll
	public static void defaultSettings(){
//		Configuration.browser="edge";
		Configuration.startMaximized=true;
		Configuration.driverManagerEnabled=true;
	}

	static String sjsite = "https://softjourn.com/";
	static Stream<Arguments> argumentsForSearch(){
		return Stream.of(
				Arguments.of("java"),
				Arguments.of("javascript")
		);
	}

	@ParameterizedTest
	@MethodSource("argumentsForSearch")
	public void searchSystem(String value) {
		new HomePage()
			.openHomePage(sjsite)
			.useSearch(value)
			.findText(value);
	}

	@Test
	public void shouldContainJava(){
		new HomePage()
			.openHomePage(sjsite)
			.scrollTillVisible("Our expertise")
			.findText("Java Development");
	}

	@Test public void contactUs(){
		new ContactPage()
			.openContactPage(sjsite)
			.setUpForms("Serhii", "+380665375916", "sergiygonchar00@gmail.com", "Ukraine", "I'm trying to test your site")
			.checkCountries("Ukraine", "United States", "Poland");
	}
}
