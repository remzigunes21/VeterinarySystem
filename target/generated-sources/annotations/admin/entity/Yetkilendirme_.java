package admin.entity;

import admin.entity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(Yetkilendirme.class)
public class Yetkilendirme_ { 

    public static volatile SingularAttribute<Yetkilendirme, Boolean> ekle;
    public static volatile SingularAttribute<Yetkilendirme, Role> roleId;
    public static volatile SingularAttribute<Yetkilendirme, String> module;
    public static volatile SingularAttribute<Yetkilendirme, Boolean> sil;
    public static volatile SingularAttribute<Yetkilendirme, Boolean> oku;
    public static volatile SingularAttribute<Yetkilendirme, Boolean> guncelle;
    public static volatile SingularAttribute<Yetkilendirme, Long> id;

}