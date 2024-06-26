package com.example.spring_booking_bot.commands;

import com.example.spring_booking_bot.helpers.DoctorHelper;
import com.example.spring_booking_bot.helpers.TimeControl;
import com.example.spring_booking_bot.helpers.UserHelper;
import com.example.spring_booking_bot.models.BootModel;
import com.example.spring_booking_bot.models.UserModel;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class ChooseTime  implements WorKerCommand{
    @Override
    public SendMessage start(Update update) {
        TimeControl timeControl = new TimeControl();
        List<String> list  = timeControl.getTimes();
        boolean ifThisCommand = false;
        for (String str:list )
        {
            if (update.getMessage().getText().equals(str))
            {
                ifThisCommand = true;
            }
        }
        if (ifThisCommand==false)
        {
            return null;
        }
        BootModel bootModel = new BootModel();
        bootModel.setTime(update.getMessage().getText().toString());
        UserModel userModel = new UserModel();
        userModel = UserHelper.findUser(update.getMessage().getFrom().getId().toString());
        bootModel.setTgId(update.getMessage().getFrom().getId().toString());
        bootModel.setDoctorEnum(userModel.getDoctorEnum());
        DoctorHelper.save(bootModel);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("ВЫ успешно записались к врачу");
        return sendMessage;

    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}
