package com.adycodes.reactspringbootdemo.service;

import com.adycodes.reactspringbootdemo.model.DemoModel;
import com.adycodes.reactspringbootdemo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public void saveData(DemoModel request) {
        demoRepository.save(request);
    }

    public List<DemoModel> getAllData() {
        return demoRepository.findAll();
    }

    public DemoModel getByRollNumber(int rollNumber) {
        return demoRepository.findByRollNumber(rollNumber);
    }
}
