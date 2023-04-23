package org.identity.conditional.auth.functions.fido;

/**
 * Class for conditional authentication function for FIDO2 key registrations.
 */
@FunctionalInterface
public interface Fido2RegistrationsFunction {

    /**
     * Check if the user has any FIDO2 key registrations.
     *
     * @param username Username of the user.
     * @return True if the user has any FIDO2 key registrations.
     */
    boolean hasFido2Registrations(String username);
}
