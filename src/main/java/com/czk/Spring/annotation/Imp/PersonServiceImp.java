package com.czk.Spring.annotation.Imp;

import com.czk.Spring.annotation.ZJPOJO.ZJPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceImp implements com.czk.Spring.annotation.Myinterface.PersonService {
    @Autowired
    public ZJPerson zjPerson =null;

    public ZJPerson getPerson() {
        return zjPerson;
    }



}
