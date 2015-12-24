package pr.jt.model;

import javax.persistence.Entity;

/**
 * Created by User on 23/12/2015.
 */


@Entity
public class Permission extends MyAbstractPersistable<Long>{

    private String name;

    public Permission(){

    }

    public Permission(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
