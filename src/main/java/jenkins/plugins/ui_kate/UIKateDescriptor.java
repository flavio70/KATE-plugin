package jenkins.plugins.ui_kate;

import hudson.model.Descriptor;

/**
 * @author Flavio Ippolito (thanks to Kohsuke Kawaguchi)
 */
public abstract class UIKateDescriptor extends Descriptor<UIKate> {
    @Override
    public String getDisplayName() {
        return clazz.getSimpleName();
    }
}
