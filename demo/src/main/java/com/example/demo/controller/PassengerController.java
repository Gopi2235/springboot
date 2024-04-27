package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import com.example.demo.service.*;
@RestController
@RequestMapping("/api")
public class PassengerController
{
    @Autowired
    private PassengerService ps;
    @PostMapping("/passenger")
    public ResponseEntity<Passenger> adddata(@RequestBody Passenger p)
    {
        Passenger obj=ps.create(p);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
    @GetMapping("/passengers") 
    public List<Passenger> fetchDepartmentList() 
    { 
        return ps.fetchDepartmentList(); 
    } 
    @GetMapping("/sort/{field}")
    public ResponseEntity<List<Passenger>> get(@PathVariable String field)
    {
        try{
            return new ResponseEntity<>(ps.getbysort(field),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/passenger/{passengerid}")
    public ResponseEntity<Passenger> putMethod(@PathVariable("passengerid") int passengerid,@RequestBody Passenger pd)
    {
        if(ps.updateDetails(passengerid,pd) == true)
        {
            return new ResponseEntity<>(pd,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/passenger/{passengerid}")
    public ResponseEntity<Boolean> delete(@PathVariable("passengerid") int passengerid)
    {
        if(ps.deleteEmployee(passengerid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
