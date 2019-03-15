package entity;

import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T15:50:22")
@StaticMetamodel(Phone.class)
public class Phone_ { 

    public static volatile SingularAttribute<Phone, String> number;
    public static volatile SingularAttribute<Phone, Person> person;
    public static volatile SingularAttribute<Phone, String> description;
    public static volatile SingularAttribute<Phone, Integer> id;

}