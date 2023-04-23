package org.identity.conditional.auth.functions.fido.internal;

import org.wso2.carbon.identity.application.authentication.framework.JsFunctionRegistry;

/**
 * Class to hold the OSGi service references.
 */
public class FidoFunctionsServiceDataHolder {

    private static final FidoFunctionsServiceDataHolder instance = new FidoFunctionsServiceDataHolder();

    private JsFunctionRegistry jsFunctionRegistry;

    /**
     * Private constructor to avoid instantiation.
     */
    private FidoFunctionsServiceDataHolder() {
    }

    /**
     * Get the instance of the FidoFunctionsServiceDataHolder.
     *
     * @return FidoFunctionsServiceDataHolder instance.
     */
    public static FidoFunctionsServiceDataHolder getInstance() {

        return instance;
    }

    /**
     * Get the JsFunctionRegistry.
     *
     * @return JsFunctionRegistry.
     */
    public JsFunctionRegistry getJsFunctionRegistry() {

        return jsFunctionRegistry;
    }

    /**
     * Set the JsFunctionRegistry.
     *
     * @param jsFunctionRegistry JsFunctionRegistry.
     */
    public void setJsFunctionRegistry(JsFunctionRegistry jsFunctionRegistry) {

        this.jsFunctionRegistry = jsFunctionRegistry;
    }
}
