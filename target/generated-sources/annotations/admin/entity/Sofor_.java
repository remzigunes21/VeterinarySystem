package admin.entity;

import admin.entity.Arac;
import admin.entity.SahaElemani;
import admin.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(Sofor.class)
public class Sofor_ { 

    public static volatile SingularAttribute<Sofor, Long> soforId;
    public static volatile SingularAttribute<Sofor, Integer> soforTc;
    public static volatile SingularAttribute<Sofor, String> soforNameSurname;
    public static volatile CollectionAttribute<Sofor, Arac> aracCollection;
    public static volatile CollectionAttribute<Sofor, SahaElemani> sahaElemaniCollection;
    public static volatile SingularAttribute<Sofor, User> userId;

}