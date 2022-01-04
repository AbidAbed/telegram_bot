import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

public class Cyber_Bot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {

    public boolean checker(String status){
        return status != "/saymyname" && status != "/convert" && status != "/tellmeajoke" && status != "/chatwithme" && status != "askme" && status != "ohnoiamsmart" && status != "/exit";
    }

    public void run(SendMessage message){
        try {
            execute(message);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }
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
        SendMessage message=new SendMessage();
        //saymyname -tells you your name
        //convert -convert hex ,dic,bin,oct
        //beacalculator -become a calculator
        //tellmeajoke -hahah it's a funny one
        //chatwithme -option under developing
        //askme -option under developing
        //ohnoiamsmart -yes yes iam smart
        //exit -exit from current command

        //BotCommand botCommand=new BotCommand();


        String status =update.getMessage().getText();

        if(status.contains(getBotUsername()))
            status=status.replaceAll(getBotUsername(),"");

        switch (status){
            case("/start"):
                break;


            case("/saymyname"):
                message.setText(update.getMessage().getFrom().getFirstName());
                message.setChatId(update.getMessage().getChatId().toString());
                run(message);
                break;


            case("/convert"):
                break;


            case("/beacalculator"):
                /*
                message.setText("********* Calculator mode activated *********");
                message.setChatId(update.getMessage().getChatId().toString());
                run(message);
                while(checker(status)){
                    message.setText("Please enter the equation in one line : Example -> 12+10*5/90+(10*7)");
                    message.setChatId(update.getMessage().getChatId().toString());
                    run(message);
                    String input =update.getMessage().getText();
                    String output=input;
                    //doing the calculations
                    message.setText("Result is : "+ output+"Hit /exit to exit the current command");
                    message.setChatId(update.getMessage().getChatId().toString());
                    run(message);
                    status =update.getMessage().getText();
                }
                ################ under developing
                */
                break;


            case("/tellmeajoke"):
                break;


            case("/chatwithme"):
                break;


            case("/askme"):
                break;


            case("/ohnoiamsmart"):
                break;


        }
        System.out.print(update.getMessage().getText()+"\n");
    }
}