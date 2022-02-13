package idea.verlif.sockect.command.answer;

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

    public Properties getProperties() {
        File file = new File(dataPath);
        if (!file.exists()) {
            File dir = file.getParentFile();
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    return null;
                }
            }
            try {
                file.createNewFile();
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
