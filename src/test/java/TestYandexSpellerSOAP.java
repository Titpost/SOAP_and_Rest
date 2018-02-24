import core.YandexSpellerSOAP;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static constants.YandexSpellerConstants.*;

/**
 * try to test SOAP via RestAssured
 */
public class TestYandexSpellerSOAP {

    @Test
    public void simpleCall(){
        YandexSpellerSOAP
                .with()
                    .text(WRONG_WORD_EN)
                    .callSOAP()
                    .then()
                    .body(Matchers.stringContainsInOrder(
                            Arrays.asList(
                                    WRONG_WORD_EN,
                                    RIGHT_WORD_EN
                            )
                    ));
    }

    @Test
    public void useRequestBuilderToChangeParams(){
        YandexSpellerSOAP
                .with()
                    .language(Languages.EN)
                    .text(WRONG_WORD_EN)
                    .options("6")
                    .callSOAP()
                    .then()
                    .body(Matchers.stringContainsInOrder(
                            Arrays.asList(
                                    WRONG_WORD_EN,
                                    RIGHT_WORD_EN
                            )
                    ));
    }
}
