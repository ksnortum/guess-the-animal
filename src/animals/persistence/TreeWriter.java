package animals.persistence;

import animals.logic.ObjectMapperGetter;
import animals.model.TreeNode;
import animals.utils.FileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class TreeWriter {
    public void writeRoot(TreeNode root, String fileType) {
        String fileName = FileUtils.getFileName(fileType);
        ObjectMapperGetter getter = new ObjectMapperGetter();
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
