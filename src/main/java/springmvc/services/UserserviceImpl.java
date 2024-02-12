package springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springmvc.Dao.UserDao;
import springmvc.models.User;

@Service
public class UserserviceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserserviceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public int saveUser(User u1) {
        userDao.saveUsertoDB(u1);

        return 1;

    }

}
