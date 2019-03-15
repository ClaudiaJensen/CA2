package entity;

import entity.Address;
import entity.Hobby;
import entity.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T15:50:22")
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