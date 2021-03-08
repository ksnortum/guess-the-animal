package animals.persistence;

import animals.logic.ObjectMapperGetter;
import animals.model.TreeNode;
import animals.model.YesNoTree;
import animals.utils.FileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class TreeLoader {
    private static final ObjectMapperGetter getter = new ObjectMapperGetter();

    public static Optional<YesNoTree> loadTree(String fileType) {
        String fileName = FileUtils.getFileName(fileType);
        Optional<ObjectMapper> mapperOptional = getter.getMapper(fileType);

        if (mapperOptional.isEmpty()) {
            return Optional.empty();
        }

        ObjectMapper mapper = mapperOptional.get();
        File file = new File(fileName);

        if (!file.exists()) {
            return Optional.empty();
        }

        TreeNode root;

        try {
            root = mapper.readValue(file, TreeNode.class);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        YesNoTree tree = new YesNoTree(root);

        return Optional.of(tree);
    }
}
