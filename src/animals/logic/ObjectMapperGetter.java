package animals.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Optional;

public class ObjectMapperGetter {
    public Optional<ObjectMapper> getMapper(String fileType) {
        switch (fileType) {
            case "json": return Optional.of(new JsonMapper());
            case "xml": return Optional.of(new XmlMapper());
            case "yaml": return Optional.of(new YAMLMapper());
            default:
                System.out.println("Bad file type");
                return Optional.empty();
        }
    }
}
