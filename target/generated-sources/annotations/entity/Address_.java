package entity;

import entity.CityInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T13:55:02")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> additionalInfo;
    public static volatile SingularAttribute<Address, CityInfo> cityInfo;
    public static volatile SingularAttribute<Address, Integer> id;

}