# identity-conditional-auth-functions-fido

This repository contains a custom adaptive authentication function written for WSO2 Identity Server to detect FIDO2 key registrations during the authentication flow.

### How to deploy the custom function

1. Build the project using the following command.
    ```
    mvn clean install
    ```

2. Copy the `identity-conditional-auth-functions-fido-1.0.0.jar` file from the target directory into the `<IS_HOME>/repository/components/dropins` directory.

3. Restart WSO2 IS.

### Sample Usage
```
var hasRegisteredFIDOKeys = hasFido2Registrations(username);
```

Refer the [blog](https://thamindudilshan.medium.com/writing-a-custom-adaptive-authentication-function-to-detect-fido2-device-registrations-87f9a9929731) for more information.
