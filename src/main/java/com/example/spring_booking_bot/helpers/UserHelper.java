package com.example.spring_booking_bot.helpers;
import com.example.spring_booking_bot.models.UserModel;
import com.example.spring_booking_bot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper
{
    final
    UserRepo userRepo;

    public UserHelper(UserRepo userRepo) {
        this.userRepo = userRepo;
        userHelper = this;
    }
    private static UserHelper userHelper  = null;


    public static void saveUser(UserModel userModel)
    {
        userHelper.userRepo.save(userModel);
    }
    public static UserModel findUser(String tgId)
    {
        UserModel userModel;
        userModel = userHelper.userRepo.findUserModelByTgId(tgId);
        return  userModel;
    }
}
