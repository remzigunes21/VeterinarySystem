package admin.entity;

import admin.entity.Sofor;
import admin.entity.User;
import admin.entity.Veteriner;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T03:21:52")
@StaticMetamodel(SahaElemani.class)
public class SahaElemani_ { 

    public static volatile SingularAttribute<SahaElemani, Sofor> soforId;
    public static volatile SingularAttribute<SahaElemani, Veteriner> veterinerId;
    public static volatile SingularAttribute<SahaElemani, Integer> elemanTc;
    public static volatile SingularAttribute<SahaElemani, String> elemanName;
    public static volatile SingularAttribute<SahaElemani, Long> elemanId;
    public static volatile SingularAttribute<SahaElemani, User> userId;

}