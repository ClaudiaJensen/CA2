/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.PersonDTO;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entity.FacadeInterface;



/**
 *
 * @author claudia
 */
public class PersonFacade implements FacadeInterface
{
    
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
     
    public EntityManager getManager() {
        return emf.createEntityManager();
    }

    
    
    public PersonFacade(){}

    public PersonFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    @Override
    public Person getPerson(String phoneNumber)
    {
        return getEntityManager().find(Person.class, phoneNumber);
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby)
    {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createQuery("Select  p.email, p.fName, p.lName FROM Person p Where :hobby MEMBER of p.hobbies ");
            q.setParameter("hobby", hobby);
            List<Person> res = q.getResultList();
            return res;
        } finally
        {
            em.close();
        }
    }
    public Hobby getHobbyById(int id ){
         EntityManager em = getEntityManager();
    try{   
           Hobby h = em.find(Hobby.class, id);
           return h;
        }finally{
                 em.close();
                }    
    }

    @Override
    public List<Person> getPersonsByCity(String city)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.createQuery("select new Person(p) From Person as p join p.addresses.cityInfo c where c.city = :city", Person.class).getResultList();
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<CityInfo> getAllzipCodes()
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.createQuery("select c.zipCode FROM CityInfo c", CityInfo.class).getResultList();
        } finally
        {
            em.close();
        }
    }

    @Override
    public int getCountPersonByHobby(Hobby hobby)
    {
//        EntityManager em = getEntityManager();
//        try
//        {
//            Query q = em.createQuery("select size(h.persons) from Hobby h where h.name = :hobby", Integer.class);
//            q.setParameter("hobby", hobby);
//            //int res = q.getResultList();
//        } finally
//        {
//            em.close();
//        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Person addPerson(Person p)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person deletePerson(int id)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person updatePerson(Person p)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }
    
    public List<PersonDTO> getAllPersonsDTO(){
        EntityManager em = getManager();
        List<PersonDTO> dtol = new ArrayList();
        
        List<Person> cs = em.createQuery("SELECT p FROM Person p").getResultList();
        for (Person c: cs){
            PersonDTO dto = new PersonDTO(c);
            dtol.add(dto);
        }
        return dtol;
    }

}
