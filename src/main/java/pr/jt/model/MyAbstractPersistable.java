package pr.jt.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;


public class MyAbstractPersistable<T extends Serializable> extends AbstractPersistable<T> {
    @Override
    public void setId(T id) {
        super.setId(id);
    }
}
