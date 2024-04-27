package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.Repository.*;

@Service
public class PassengerService {
   
    @Autowired
    PassengerRepo pr;

    //post
    public Passenger create(Passenger p)
    {
       
        return pr.save(p);
    }

    //getbyid
 
    public List<Passenger> fetchDepartmentList() 
    { 
        return (List<Passenger>) pr.findAll(); 
    } 
    //getbyid
    public Passenger getbyid(int passengerid)
    {
        return pr.findById(passengerid).orElse(null);
    }
    public List<Passenger> getbysort(String field)
    {
        return pr.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    //put
    public boolean updateDetails(int passengerid,Passenger p)
        {
            if(pr.findById(passengerid)==null)
            {
                return false;
            }
            try{
                pr.save(p);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteEmployee(int passengerid)
        {
            if(this.getbyid(passengerid) == null)
            {
                return false;
            }
            pr.deleteById(passengerid);
            return true;
        }

}
