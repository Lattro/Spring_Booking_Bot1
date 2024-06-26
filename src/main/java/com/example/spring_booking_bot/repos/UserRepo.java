package com.example.spring_booking_bot.repos;
import org.springframework.data.repository.CrudRepository;
import com.example.spring_booking_bot.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long>{
    UserModel findUserModelByTgId(String id);
}
