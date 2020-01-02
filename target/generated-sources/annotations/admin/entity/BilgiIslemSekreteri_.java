package admin.entity;

import admin.entity.Belediye;
import admin.entity.User;
import admin.entity.Veteriner;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(BilgiIslemSekreteri.class)
public class BilgiIslemSekreteri_ { 

    public static volatile SingularAttribute<BilgiIslemSekreteri, Veteriner> veterinerId;
    public static volatile SingularAttribute<BilgiIslemSekreteri, Integer> biSekreterTc;
    public static volatile SingularAttribute<BilgiIslemSekreteri, Long> biSekreterId;
    public static volatile CollectionAttribute<BilgiIslemSekreteri, Belediye> belediyeCollection;
    public static volatile SingularAttribute<BilgiIslemSekreteri, String> biSekreterNameSurname;
    public static volatile SingularAttribute<BilgiIslemSekreteri, User> userId;

}