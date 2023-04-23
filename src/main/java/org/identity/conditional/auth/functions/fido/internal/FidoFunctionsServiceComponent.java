package org.identity.conditional.auth.functions.fido.internal;

import org.identity.conditional.auth.functions.fido.Fido2RegistrationsFunction;
import org.identity.conditional.auth.functions.fido.Fido2RegistrationsFunctionImpl;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.identity.application.authentication.framework.JsFunctionRegistry;

/**
 * OSGi declarative services component which handles registration and un-registration of FIDO
 * conditional authentication functions.
 */
@Component(
        name = "identity.conditional.auth.functions.fido.component",
        immediate = true
)
public class FidoFunctionsServiceComponent {

    @Activate
    protected void activate(ComponentContext context) {

        Fido2RegistrationsFunction fido2RegistrationsFunction = new Fido2RegistrationsFunctionImpl();
        FidoFunctionsServiceDataHolder.getInstance().getJsFunctionRegistry().register(
                JsFunctionRegistry.Subsystem.SEQUENCE_HANDLER, "hasFido2Registrations", fido2RegistrationsFunction);
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {

        JsFunctionRegistry jsFunctionRegistry = FidoFunctionsServiceDataHolder.getInstance().getJsFunctionRegistry();
        if (jsFunctionRegistry != null) {
            jsFunctionRegistry.deRegister(JsFunctionRegistry.Subsystem.SEQUENCE_HANDLER, "hasFido2Registrations");
        }
    }

    @Reference(
            service = JsFunctionRegistry.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetJsFunctionRegistry"
    )
    public void setJsFunctionRegistry(JsFunctionRegistry jsFunctionRegistry) {

        FidoFunctionsServiceDataHolder.getInstance().setJsFunctionRegistry(jsFunctionRegistry);
    }

    public void unsetJsFunctionRegistry(JsFunctionRegistry jsFunctionRegistry) {

        FidoFunctionsServiceDataHolder.getInstance().setJsFunctionRegistry(null);
    }
}
