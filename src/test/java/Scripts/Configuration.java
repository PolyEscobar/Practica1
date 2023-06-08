package Scripts;

import java.util.Properties;

public class Configuration {
    public static final String PROPERTIES_FILE_PATH = "src/test/resources/properties/";
    public static final String KEY_PROPERTIES_PATH = PROPERTIES_FILE_PATH+"Keys_%s.properties";
    public static final Properties KEY_PROPERTIES_FILE = Commons.getProperties(String.format(KEY_PROPERTIES_PATH, "EN"));


}
