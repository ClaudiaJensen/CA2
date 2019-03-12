/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hassuni
 */
public class PersonDTO {

    private int id;
    private String email;
    private String fName;
    private String lName;
    
    private List<String> phones = new ArrayList();
    private List<String> hobbys = new ArrayList();
    
    
    
    public PersonDTO(Person p){
        this.id = p.getId();
        this.email = p.getEmail();
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.phones = getPhones(p.getPhones());
        this.hobbys = getHobbys(p.getHobbys());
    }
    
    public List<String> getPhones(List<Phone> pList){
        List<String> sList = new ArrayList();
        for (Phone p: pList){
            String s = "PhoneNumber: " + p.getNumber().toString() + "description: " + p.getDescription() + "  ";
            sList.add(s);
        }
        return sList;
    }
    
     public List<String> getHobbys(List<Hobby> hList){
        List<String> sList = new ArrayList();
        for (Hobby h: hList){
            String s = "Name: " + h.getName() + "description: " + h.getDescription() + "  ";
            sList.add(s);
        }
        return sList;
    }
}
