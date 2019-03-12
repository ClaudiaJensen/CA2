/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.BusinessLogic;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author claudia
 */
public class PersonFacade implements BusinessLogic
{

    EntityManagerFactory emf;

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
    try{
            Query q = em.createQuery("Select p.fName, p.lName, p.email FROM Person p Where :hobby in p.hobbies ");
            q.setParameter("hobby", hobby);
            List<Person> res = q.getResultList();  
            return res;
        }finally{
                 em.close();
                }
    }

    @Override
    public List<Person> getPersonsByCity(String city)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCountPersonByHobby(Hobby hobby)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CityInfo> getAllzipCodes()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person addPerson(Person p)
    {
         EntityManager em = getEntityManager();
          try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }finally{
            em.close();
        }
    }

    @Override
    public Person deletePerson(int id)
    {
        EntityManager em = getEntityManager();
    try{
         em.getTransaction().begin();   
        Person p = em.find(Person.class, id);
        em.remove(p);
        em.getTransaction().commit();
        return p; 
        }finally{
                 em.close();
                }
    }

    @Override
    public Person updatePerson(Person p)
    {
              EntityManager em = getEntityManager();
    try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return p;     
        }finally{
                 em.close();
                }      
    }

}
