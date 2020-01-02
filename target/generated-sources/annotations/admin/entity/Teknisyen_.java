package admin.entity;

import admin.entity.User;
import admin.entity.Veteriner;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(Teknisyen.class)
public class Teknisyen_ { 

    public static volatile SingularAttribute<Teknisyen, Veteriner> veterinerId;
    public static volatile SingularAttribute<Teknisyen, Long> teknisyenId;
    public static volatile SingularAttribute<Teknisyen, String> teknisyenBilgi;
    public static volatile SingularAttribute<Teknisyen, User> userId;
    public static volatile SingularAttribute<Teknisyen, String> teknisyenName;

}