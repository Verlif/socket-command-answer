package idea.verlif.sockect.command.answer;

import idea.verlif.socket.command.SocketCommand;
import idea.verlif.socket.core.server.holder.ClientHolder;

/**
 * @author Verlif
 */
public class AnswerCommand implements SocketCommand<AnswerConfig> {

    private static final String RELOAD = "__RELOAD";

    private AnswerEcho echo;

    @Override
    public String[] keys() {
        return new String[]{"answer"};
    }

    @Override
    public void onLoad(AnswerConfig answerConfig) {
        this.echo = new AnswerEcho(answerConfig);
    }

    @Override
    public void run(ClientHolder.ClientHandler clientHandler, String s) {
        if (s.equals(RELOAD)) {
            echo.reload();
        } else {
            clientHandler.sendMessage(echo.answer(s));
        }
    }
}
