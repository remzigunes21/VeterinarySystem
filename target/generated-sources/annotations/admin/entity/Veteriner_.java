package admin.entity;

import admin.entity.BilgiIslemSekreteri;
import admin.entity.Muhasebeci;
import admin.entity.SahaElemani;
import admin.entity.Stok;
import admin.entity.Teknisyen;
import admin.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(Veteriner.class)
public class Veteriner_ { 

    public static volatile SingularAttribute<Veteriner, Long> veterinerId;
    public static volatile SingularAttribute<Veteriner, Integer> veterinerSicilNu;
    public static volatile CollectionAttribute<Veteriner, Teknisyen> teknisyenCollection;
    public static volatile CollectionAttribute<Veteriner, BilgiIslemSekreteri> bilgiIslemSekreteriCollection;
    public static volatile CollectionAttribute<Veteriner, Muhasebeci> muhasebeciCollection;
    public static volatile SingularAttribute<Veteriner, String> veterinerNameSurname;
    public static volatile SingularAttribute<Veteriner, Stok> stokId;
    public static volatile CollectionAttribute<Veteriner, SahaElemani> sahaElemaniCollection;
    public static volatile SingularAttribute<Veteriner, User> userId;
    public static volatile SingularAttribute<Veteriner, Integer> veterinerTc;

}