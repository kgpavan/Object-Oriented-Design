
/**
 * Example implementation of the simple User converter.
 */
public class UserConverter extends Converter<UserDto, User> {

	/**
	* Constructor.
	*/
	public UserConverter() {

		super(userDto -> new User(userDto.getFirstName(), userDto.getLastName(), 
										userDto.isActive(), userDto.getEmail()),
		      user -> new UserDto(user.getFirstName(), user.getLastName(), 
		            					user.isActive(), user.getUserId()));
	}
}
