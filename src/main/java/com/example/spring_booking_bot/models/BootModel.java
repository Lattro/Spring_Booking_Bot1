package com.example.spring_booking_bot.models;

import com.example.spring_booking_bot.helpers.DoctorEnum;
//import jakarta.persistence.*;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book_list")
@Data
public class BootModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "doctor")
    @Enumerated
    DoctorEnum doctorEnum;
    @Column(name = "time")
    String time;

    @Column(name = "th_id")
    String tgId;



}
