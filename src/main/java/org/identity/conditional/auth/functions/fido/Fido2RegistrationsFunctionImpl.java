package org.identity.conditional.auth.functions.fido;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authenticator.fido2.core.WebAuthnService;
import org.wso2.carbon.identity.application.authenticator.fido2.dto.FIDO2CredentialRegistration;
import org.wso2.carbon.identity.application.authenticator.fido2.exception.FIDO2AuthenticatorServerException;

import java.util.Collection;

/**
 * Implementation of the Fido2RegistrationsFunction.
 */
public class Fido2RegistrationsFunctionImpl implements Fido2RegistrationsFunction {

    private static final Log LOG = LogFactory.getLog(Fido2RegistrationsFunctionImpl.class);

    @Override
    public boolean hasFido2Registrations(String username) {

        WebAuthnService webAuthnService = new WebAuthnService();
        try {
            Collection<FIDO2CredentialRegistration> fido2CredentialRegistration = webAuthnService
                    .getFIDO2DeviceMetaData(username);

            if (CollectionUtils.isNotEmpty(fido2CredentialRegistration)) {
                return true;
            }
        } catch (FIDO2AuthenticatorServerException e) {
            LOG.error("Error while retrieving FIDO2 registrations for user: " + username, e);
        }

        return false;
    }
}
