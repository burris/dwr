package uk.ltd.getahead.dwr.create;

import org.apache.struts.action.ActionForm;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.util.RequestUtils;

import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.ExecutionContext;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

/**
 * StrutsCreator
 * @author Ariel O. Falduto
 */
public class StrutsCreator extends AbstractCreator implements Creator
{
    /**
     * Struts formBean to be retrived
     * @param formBean Struts bean form related.
     */
    public void setFormBean(String formBean)
    {
        this.formBean = formBean;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Creator#getType()q
     */
    public Class getType()
    {
        if (moduleConfig == null)
        {
            synchronized (syncFlag)
            {
                if (moduleConfig == null)
                {
                    WebContext wc = WebContextFactory.get();
                    moduleConfig = RequestUtils.getModuleConfig(wc.getHttpServletRequest(), wc.getServletContext()); //$NON-NLS-1$
                    //moduleConfig = ModuleUtils.getInstance().getModuleConfig("", ExecutionContext.get().getServletContext());
                }
            }
        }

        try
        {
            return Class.forName(moduleConfig.findFormBeanConfig(formBean).getType());
        }
        catch (ClassNotFoundException ex)
        {
            throw new IllegalArgumentException(Messages.getString("Creator.ClassNotFound", moduleConfig.findFormBeanConfig(formBean).getType())); //$NON-NLS-1$
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Creator#getInstance()
     */
    public Object getInstance() throws InstantiationException
    {
        // fills for the first time the moduleConfig
        ActionForm formInstance = (ActionForm) ExecutionContext.get().getSession().getAttribute(formBean);
        if (formInstance == null)
        {
            throw new InstantiationException(Messages.getString("Creator.IllegalAccess")); //$NON-NLS-1$
        }

        return formInstance;
    }

    private String formBean;
    private ModuleConfig moduleConfig;
    private Object syncFlag = new Object();
}
