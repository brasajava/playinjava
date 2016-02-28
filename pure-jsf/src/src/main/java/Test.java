import com.brasajava.beans.User;
import com.brasajava.repositories.UserRepository;

public class Test {
	public void main(String[] args) {
		User user = new User();
		user.setName("Ricardo Test");
		UserRepository repository = new UserRepository();
		repository.save(user);
		
		for(User u : repository.findAll()){
			System.out.println(u.getName());
		}
	}

}
