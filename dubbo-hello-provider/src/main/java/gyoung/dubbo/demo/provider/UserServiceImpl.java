package gyoung.dubbo.demo.provider;

/**
 * Created by zengjiyang on 2016/2/16.
 */
import gyoung.dubbo.demo.api.User;
import gyoung.dubbo.demo.api.UserService;

public class UserServiceImpl implements UserService {

    public User getUser(Long id) {
        return new User(id, "username" + id);
    }
}
