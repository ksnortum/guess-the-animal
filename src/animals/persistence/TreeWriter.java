package animals.persistence;

import animals.logic.ObjectMapperGetter;
import animals.model.YesNoTree;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class TreeWriter {
    private static final ObjectMapperGetter getter = new ObjectMapperGetter();

    public void writeRoot(YesNoTree.Node root, String fileType) {
        System.out.println(root); // TODO debug
        String fileName = "animals." + fileType;
        Optional<ObjectMapper> mapperOptional = getter.getMapper(fileType);

        if (mapperOptional.isEmpty()) {
            return;
        }

        ObjectMapper mapper = mapperOptional.get();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
