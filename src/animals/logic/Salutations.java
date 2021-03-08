package animals.logic;

import animals.utils.PropertiesUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Salutations {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();
    private final Random random = new Random();

    public void goodbye() {
        List<String> goodbyes = getGoodbyes();
        System.out.println();
        System.out.println(goodbyes.get(random.nextInt(goodbyes.size())));
    }

    private List<String> getGoodbyes() {
        String farewellString = messagesBundle.getString("farewell");
        return Arrays.asList(farewellString.split("\f"));
    }
}
