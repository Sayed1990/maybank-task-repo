<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/service/PublicApiService.java
========
<<<<<<< HEAD
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/PublicApiService.java
package com.maybanktask.user_management.service;

import java.io.IOException;
import java.util.List;

public interface PublicApiService {
    List<String> getDataByRestTemplate();

    List<String> getDataByProducerTemplate() throws IOException;
}
<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/service/PublicApiService.java
========
=======
package com.maybanktask.user_management.service;

import java.io.IOException;
import java.util.List;

public interface PublicApiService {
    List<String> getDataByRestTemplate();

    List<String> getDataByProducerTemplate() throws IOException;
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/PublicApiService.java
