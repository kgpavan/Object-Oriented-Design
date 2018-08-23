
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;


/**
 * The Converter pattern is a behavioral design pattern which allows a common way of bidirectional
 * conversion between corresponding types (e.g. DTO and domain representations of the logically
 * isomorphic types). Moreover, the pattern introduces a common way of converting a collection of
 * objects between types.
*/
public class App {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {

        Converter<UserDto, User> userConverter = new UserConverter();

        UserDto dtoUser = new UserDto("John", "Doe", true, "whatever[at]wherever.com");
        User user = userConverter.convertFromDto(dtoUser);
        System.out.println("Entity converted from DTO:" + user);

        ArrayList<User> users = Lists.newArrayList(new User("Camile", "Tough", false, "124sad"),
            new User("Marti", "Luther", true, "42309fd"), new User("Kate", "Smith", true, "if0243"));
        System.out.println("Domain entities:");
        users.forEach(System.out::println);

        System.out.println("DTO entities converted from domain:");
        List<UserDto> dtoEntities = userConverter.createFromEntities(users);
        dtoEntities.forEach(System.out::println);
    }
}
