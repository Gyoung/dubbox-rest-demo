package gyoung.dubbo.demo.api;

/**
 * Created by zengjiyang on 2016/2/16.
 */
import javax.validation.constraints.Min;

public interface UserRestService {
    User getUser(@Min(value = 1L, message = "User ID must be greater than 1") Long id);
}