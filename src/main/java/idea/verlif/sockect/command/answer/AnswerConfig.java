package idea.verlif.sockect.command.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import idea.verlif.socket.command.config.ConfigAdapter;

import java.io.*;
import java.util.Properties;

/**
 * @author Verlif
 */
public class AnswerConfig implements ConfigAdapter {

    private String dataPath = "config/answer/answerMap.properties";

    @Override
    public String key() {
        return "answer";
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    @JsonIgnore
    public Properties getProperties() {
        File file = new File(dataPath);
        if (!file.exists()) {
            File dir = file.getParentFile();
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    return null;
                }
            }
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("hello=hello");
                writer.flush();
            } catch (IOException ignored) {
            }
        }
        if (file.exists()) {
            Properties properties = new Properties();
            try {
                properties.load(new FileReader(file));
            } catch (IOException ignored) {
            }
            return properties;
        } else {
            return null;
        }
    }
}
