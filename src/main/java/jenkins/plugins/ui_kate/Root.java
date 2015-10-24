package jenkins.plugins.ui_kate;

import hudson.Extension;
import hudson.model.RootAction;
import jenkins.model.ModelObjectWithContextMenu;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import java.util.List;

/**
 * Entry point to all the GUI items.
 * 
 * @author Flavio Ippolito
 */
@Extension
public class Root implements RootAction, ModelObjectWithContextMenu {
    public String getIconFileName() {
        return "gear2.png";
    }

    public String getDisplayName() {
        return "K@TE";
    }

    public String getUrlName() {
        return "kate";
    }

    public UIKate getDynamic(String name) {
        for (UIKate ui : getAll())
            if (ui.getUrlName().equals(name))
                return ui;
        return null;
    }

    public List<UIKate> getAll() {
        return UIKate.all();
    }
    
    public List<UIKate> getAllGroovy() {
      return UIKate.getGroovySamples();
    }

    public List<UIKate> getAllOther() {
      return UIKate.getOtherSamples();
    }
    
    public ContextMenu doContextMenu(StaplerRequest request, StaplerResponse response) throws Exception {
        //return new ContextMenu().addAll(getAll());
        return new ContextMenu()
            .add(new MenuItem().withContextRelativeUrl("/" + getUrlName() + "/JobDevelopment").withStockIcon("plugin.png").withDisplayName("Job Development"));
    }
}
