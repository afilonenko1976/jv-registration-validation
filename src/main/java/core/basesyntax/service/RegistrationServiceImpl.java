package core.basesyntax.service;

import core.basesyntax.UserNotRegisterException;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.User;

public class RegistrationServiceImpl implements RegistrationService {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public User register(User user) {

        if (user == null) {
            throw new UserNotRegisterException("User is null.");
        }

        if (user.getLogin() == null) {
            throw new UserNotRegisterException("Login user's is null.");
        }

        if (user.getPassword() == null) {
            throw new UserNotRegisterException("Password user's is null.");
        }

        if (user.getAge() == null) {
            throw new UserNotRegisterException("Age user`s is null.");
        }

        if (user.getLogin().length() == 0) {
            throw new UserNotRegisterException("Login user's is empty string.");
        }

        if (user.getPassword().length() == 0) {
            throw new UserNotRegisterException("\"Password user's is empty string.");
        }

        if (user.getAge() == 0) {
            return null;
        }

        if (user.getLogin().length() < 6) {
            return null;
        }

        if (user.getPassword().length() < 6) {
            return null;
        }

        if (user.getAge() < 18) {
            return null;
        }

        User userLogin = storageDao.get(user.getLogin());
        if (user.equals(userLogin)) {
            return null;
        }

        storageDao.add(user);

        return user;
    }
}
