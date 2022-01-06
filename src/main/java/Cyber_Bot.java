import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

public class Cyber_Bot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {

    private String extract_recived_command(Update update){
        return update.getMessage().getText().toString();
    }

    private Long extract_id(Update update){
        return update.getMessage().getChatId();
    }


    private void send(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void say_my_name(Update update){
        SendMessage message=new SendMessage();
        message.setText(update.getMessage().getFrom().getFirstName()+" :)");
        message.setChatId(update.getMessage().getChatId().toString());
        send(message);
    }

    private void say_your_name(Update update){
        SendMessage message=new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("I'm mesho karamesho :)) nice to meet you!");
        send(message);
    }
    @Override
    public String getBotUsername() {
        return ""; //your bot's username
    }

    @Override
    public String getBotToken() {
        return ""; //your token
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(extract_recived_command(update));
        String command = extract_recived_command(update);
        switch (command){
            case("/say_my_name"): say_my_name(update);
            case("/say_your_name"): say_your_name(update);
            case("/ban_member"):
            case("/toxic_words"):
            case("/tell_me_a_joke"):
            case("/conversion_table"):
        }
    }
}