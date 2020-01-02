package admin.entity;

import admin.entity.Stok;
import admin.entity.User;
import admin.entity.Veteriner;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(Muhasebeci.class)
public class Muhasebeci_ { 

    public static volatile SingularAttribute<Muhasebeci, Integer> muhasebeSicil;
    public static volatile SingularAttribute<Muhasebeci, Veteriner> veterinerId;
    public static volatile SingularAttribute<Muhasebeci, Long> muhasebeciId;
    public static volatile SingularAttribute<Muhasebeci, Integer> muhasebeTc;
    public static volatile SingularAttribute<Muhasebeci, String> muhasebeNameSurname;
    public static volatile SingularAttribute<Muhasebeci, Stok> ilacId;
    public static volatile SingularAttribute<Muhasebeci, User> userId;

}