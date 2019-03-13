/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author claudia
 */
public interface FacadeInterface
{

    public Person getPerson(String phoneNumber);

    public List<Person> getPersonsByHobby(Hobby hobby);

    public List<Person> getPersonsByCity(String city);

    public int getCountPersonByHobby(Hobby hobby);

    public List<CityInfo> getAllzipCodes();

    //CRUD
    public Person addPerson(Person p);

    public Person deletePerson(int id);

    public Person updatePerson(Person p);
    
}
