package admin.entity;

import admin.entity.BilgiIslemSekreteri;
import admin.entity.Muhasebeci;
import admin.entity.Role;
import admin.entity.SahaElemani;
import admin.entity.Sofor;
import admin.entity.Teknisyen;
import admin.entity.Veteriner;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> userPassword;
    public static volatile CollectionAttribute<User, Teknisyen> teknisyenCollection;
    public static volatile CollectionAttribute<User, BilgiIslemSekreteri> bilgiIslemSekreteriCollection;
    public static volatile SingularAttribute<User, Role> roleId;
    public static volatile CollectionAttribute<User, Veteriner> veterinerCollection;
    public static volatile SingularAttribute<User, String> userEmail;
    public static volatile CollectionAttribute<User, Muhasebeci> muhasebeciCollection;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile CollectionAttribute<User, SahaElemani> sahaElemaniCollection;
    public static volatile SingularAttribute<User, Long> userId;
    public static volatile CollectionAttribute<User, Sofor> soforCollection;

}