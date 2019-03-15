package entity;

import entity.CityInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T13:55:02")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T14:15:40")
>>>>>>> 330602a189a8731bccc9f6f5effdba5e0c5c1984
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> additionalInfo;
    public static volatile SingularAttribute<Address, CityInfo> cityInfo;
    public static volatile SingularAttribute<Address, Integer> id;

}