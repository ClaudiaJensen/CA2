/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dto.PersonDTO;
import java.util.List;

/**
 *
 * @author claudia
 */
public interface FacadeInterface
{

    public PersonDTO getPerson(String phoneNumber);

    public List<PersonDTO> getPersonsByHobby(String name);

    public List<PersonDTO> getPersonsByCity(String city);

    public int getCountPersonByHobby(String name);

    public List<CityInfo> getAllzipCodes();

    //CRUD
    public Person addPerson(Person p);

    public Person deletePerson(int id);

    public Person updatePerson(Person p);
    
}
