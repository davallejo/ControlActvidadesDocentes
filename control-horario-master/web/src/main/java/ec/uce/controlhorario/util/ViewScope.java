package ec.uce.controlhorario.util;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * @author dacopanCM on 10/03/17.
 */
public class ViewScope implements Scope {
    public Object get(String name, ObjectFactory<? extends Object> objectFactory) {
        Map<String, Object> viewMap = FacesContext.getCurrentInstance()
                .getViewRoot().getViewMap();
        Object obj;
        if (viewMap.containsKey(name)) {
            obj = viewMap.get(name);
        } else {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);
            obj = object;
        }
        return obj;
    }

    public Object remove(String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
                .remove(name);
    }

    public String getConversationId() {
        return null;
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        // Not supported
    }

    public Object resolveContextualObject(String key) {
        return null;
    }
}