package animals.view;

import animals.utils.LanguageRules;
import animals.utils.PropertiesUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class GameControllerView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();
    private final Random random = new Random();

    public void printLetsPlay() {
        System.out.println(messagesBundle.getString("game.letsPlay"));
    }

    public void printThinkOfAnAnimal() {
        System.out.println(messagesBundle.getString("game.think"));
    }

    public String getEnterPrompt() {
        return messagesBundle.getString("game.enter");
    }

    public String getQuestion(String fact) {
        return LanguageRules.prepareQuestionFact(fact);
    }

    public String getGameAgain() {
        return getRandomPrompt("game.again");
    }

    public void printGameWin() {
        System.out.println(getRandomPrompt("game.win"));
    }

    public String getGiveUp() {
        return messagesBundle.getString("game.giveUp");
    }

    private String getRandomPrompt(String key) {
        String promptString = messagesBundle.getString(key);
        List<String> prompts = Arrays.asList(promptString.split("\f"));

        return prompts.get(random.nextInt(prompts.size()));
    }
}
