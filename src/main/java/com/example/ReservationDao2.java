package com.example;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Dao
@ConfigAutowireableDS2
public interface ReservationDao2 {
    @Select
    List<Reservation> selectAll();

    @Select
    List<Reservation> selectByName(String name);

    @Insert
    @Transactional
    int insert(Reservation reservation);
}
