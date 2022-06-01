package com.adycodes.reactspringbootdemo.repository;

import com.adycodes.reactspringbootdemo.model.DemoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoModel, Integer> {

    public DemoModel findByRollNumber(int rollNumber);

}
