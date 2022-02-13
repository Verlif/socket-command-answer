package idea.verlif.sockect.command.answer;

import java.util.Properties;

/**
 * @author Verlif
 */
public class AnswerEcho {

    private final Properties properties;

    public AnswerEcho(AnswerConfig config) {
        properties = config.getProperties();
    }

    /**
     * 获取问题的回答
     *
     * @param question 问题文本
     * @return 对应问题的回答
     */
    public String answer(String question) {
        return properties == null ? "Unknown!" : properties.getProperty(question);
    }
}
