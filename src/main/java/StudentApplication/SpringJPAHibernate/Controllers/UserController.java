package StudentApplication.SpringJPAHibernate.Controllers;

import java.util.List;
import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public User save(@RequestBody User userObj){
        User userResponse = userRepoObj.save(userObj);
        System.out.println(userResponse);
        return userResponse;
    };

    //delete and findall(return type list)
    @DeleteMapping("/deleterow")
    public void deleteUser(@RequestBody User userObj)  {
        userRepoObj.delete(userObj);
    }

    //get all users
    @GetMapping("/getallusers")
    public List<User> getallusers(){
        List<User> userlist = userRepoObj.findAll();
        System.out.println(userlist);
        return userlist;
    }

    @GetMapping("/")
    public String index() {
        return "Hello!!!";
    }

}

