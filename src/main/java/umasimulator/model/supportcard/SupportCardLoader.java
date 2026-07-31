package umasimulator.model.supportcard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

public class SupportCardLoader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static SupportCard load(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), SupportCard.class);
    } 
}