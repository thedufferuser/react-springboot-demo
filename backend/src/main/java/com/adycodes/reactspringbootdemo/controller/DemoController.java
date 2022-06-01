package com.adycodes.reactspringbootdemo.controller;

import com.adycodes.reactspringbootdemo.model.DemoModel;
import com.adycodes.reactspringbootdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demoapi")
@CrossOrigin
public class DemoController {

    @Autowired
    private DemoService service;

    @PostMapping("/add-record")
    public ResponseEntity<String> addRecord(@RequestBody DemoModel request) {
        service.saveData(request);
        return new ResponseEntity<>("New record added!", HttpStatus.OK);
    }

    @GetMapping("/get-all-records")
    public ResponseEntity<List<DemoModel>> getAllRecords() {
        return new ResponseEntity<>(service.getAllData(), HttpStatus.OK);
    }

    @GetMapping("/get-roll-num/{rollNumber}")
    public ResponseEntity<DemoModel> getRecordByRollNumber(@PathVariable int rollNumber) {
        return new ResponseEntity<>(service.getByRollNumber(rollNumber), HttpStatus.OK);
    }
}
