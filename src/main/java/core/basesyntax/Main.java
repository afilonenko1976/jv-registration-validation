package core.basesyntax;

import core.basesyntax.model.User;
import core.basesyntax.service.RegistrationService;
import core.basesyntax.service.RegistrationServiceImpl;

public class Main {

    public static void main(String[] args) {

        User user1 = new User();
        user1.setLogin("Angei1976");
        user1.setPassword("111111");
        user1.setAge(25);

        RegistrationService registrationService = new RegistrationServiceImpl();
        registrationService.register(user1);

    }
}
