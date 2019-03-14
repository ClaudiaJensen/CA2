/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Address;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Hassuni
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String fName;
    private String lName;

   @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
   private final List<Phone> phones = new ArrayList();
   
   @ManyToMany(cascade = CascadeType.ALL)
   private final List<Hobby> hobbies = new ArrayList();

   @ManyToOne(cascade = CascadeType.PERSIST)
   private Address addresses;
   
    
    public Person() {
    }

    public Person(String email, String fName, String lName) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }
    

    public Person(int id, String email, String fName, String lName) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entitys.Person[ id=" + id + " ]";
    }

   public void addHobby(Hobby h){
       this.hobbies.add(h);
   }
   
   public void addPhone(Phone p){
       if(p.getPerson() == null) 
       p.setPerson(this); //Fordi det er bidirectional 
       this.phones.add(p);
   }
   
   public void setAddress(Address a){
       this.addresses = a;
   }

    public List<Phone> getPhones() {
        return phones;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public Address getAddresses() {
        return addresses;
    }
   
}
