package gyoung.dubbo.demo.provider;

/**
 * Created by zengjiyang on 2016/2/16.
 */
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import gyoung.dubbo.demo.api.User;
import gyoung.dubbo.demo.api.UserRestService;
import gyoung.dubbo.demo.api.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UserRestServiceImpl implements UserRestService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("{id : \\d+}")
    public User getUser(@PathParam("id") Long id) {
        if (RpcContext.getContext().getRequest(HttpServletRequest.class) != null) {
            System.out.println("Client IP address from RpcContext: " + RpcContext.getContext().getRequest(HttpServletRequest.class).getRemoteAddr());
        }
        if (RpcContext.getContext().getResponse(HttpServletResponse.class) != null) {
            System.out.println("Response object from RpcContext: " + RpcContext.getContext().getResponse(HttpServletResponse.class));
        }
        return userService.getUser(id);
    }
}