package com.maybanktask.user_management.utils;

public class AspectConstant {
    private AspectConstant() {
    }

    public static final String USER_CONTROLLER_HOMEPATH="execution(* com.maybanktask.user_management.controller.UserController.*(..))";
    public static final String REGISTER_USER_API_PATH= "controllerMethods() && args(registration,..)";
    public static final String VALIDATE_USER_LOGIN_PATH="controllerMethods() && args(email, password,..)";
}
