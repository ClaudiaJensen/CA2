package entity;

import entity.Address;
import entity.Hobby;
import entity.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T13:55:02")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T14:15:40")
>>>>>>> 330602a189a8731bccc9f6f5effdba5e0c5c1984
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> lName;
    public static volatile SingularAttribute<Person, Address> addresses;
    public static volatile SingularAttribute<Person, String> fName;
    public static volatile ListAttribute<Person, Hobby> hobbies;
    public static volatile ListAttribute<Person, Phone> phones;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, String> email;

}