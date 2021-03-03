package animals.controller;

import animals.logic.CommandLineParser;
import animals.logic.Greeter;
import animals.logic.Salutations;
import animals.model.Animal;
import animals.model.YesNoTree;
import animals.persistence.TreeLoader;
import animals.persistence.TreeWriter;

import java.util.Optional;

public class MainController {
    CommandLineParser commandLineParser = new CommandLineParser();
    Greeter greeter = new Greeter();
    FirstAnimalController firstAnimalController = new FirstAnimalController();
    MenuController menuController = new MenuController();
    TreeWriter writer = new TreeWriter();
    Salutations salutations = new Salutations();

    public void run(String... args) {
        String fileType = commandLineParser.parseFileType(args);
        greeter.greeting();
        Optional<YesNoTree> treeOptional = TreeLoader.loadTree(fileType);
        YesNoTree tree = new YesNoTree();

        if (treeOptional.isEmpty()) {
            Animal firstAnimal = firstAnimalController.execute();
            tree.firstAnimal(firstAnimal);
        } else {
            tree = treeOptional.get();
        }

        System.out.println("Welcome to the animal expert system!");
        menuController.execute(tree);
        writer.writeRoot(tree.getRoot(), fileType);
        salutations.goodbye();
    }
}
