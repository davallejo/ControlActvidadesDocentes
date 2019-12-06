package controladores.estandar;

import entidades.CabeceraReunion;
import controladores.util.JsfUtil;
import controladores.util.JsfUtil.PersistAction;
import sesiones.estandar.CabeceraReunionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("cabeceraReunionController")
@SessionScoped
public class CabeceraReunionController implements Serializable {

    @EJB
    private sesiones.estandar.CabeceraReunionFacade ejbFacade;
    private List<CabeceraReunion> items = null;
    private CabeceraReunion selected;

    public CabeceraReunionController() {
    }

    public CabeceraReunion getSelected() {
        return selected;
    }

    public void setSelected(CabeceraReunion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CabeceraReunionFacade getFacade() {
        return ejbFacade;
    }

    public CabeceraReunion prepareCreate() {
        selected = new CabeceraReunion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CabeceraReunionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CabeceraReunionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CabeceraReunionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CabeceraReunion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public CabeceraReunion getCabeceraReunion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CabeceraReunion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CabeceraReunion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CabeceraReunion.class)
    public static class CabeceraReunionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CabeceraReunionController controller = (CabeceraReunionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cabeceraReunionController");
            return controller.getCabeceraReunion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CabeceraReunion) {
                CabeceraReunion o = (CabeceraReunion) object;
                return getStringKey(o.getIdReunion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CabeceraReunion.class.getName()});
                return null;
            }
        }

    }

}
