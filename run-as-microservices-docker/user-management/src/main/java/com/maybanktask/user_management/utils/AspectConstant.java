<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/utils/AspectConstant.java
========
<<<<<<< HEAD
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/utils/AspectConstant.java
package com.maybanktask.user_management.utils;

public class AspectConstant {
    private AspectConstant() {
    }

    public static final String USER_CONTROLLER_HOMEPATH="execution(* com.maybanktask.user_management.controller.UserController.*(..))";
    public static final String REGISTER_USER_API_PATH= "controllerMethods() && args(registration,..)";
    public static final String VALIDATE_USER_LOGIN_PATH="controllerMethods() && args(email, password,..)";
}
<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/utils/AspectConstant.java
========
=======
package com.maybanktask.user_management.utils;

public class AspectConstant {
    private AspectConstant() {
    }

    public static final String USER_CONTROLLER_HOMEPATH="execution(* com.maybanktask.user_management.controller.UserController.*(..))";
    public static final String REGISTER_USER_API_PATH= "controllerMethods() && args(registration,..)";
    public static final String VALIDATE_USER_LOGIN_PATH="controllerMethods() && args(email, password,..)";
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/utils/AspectConstant.java
