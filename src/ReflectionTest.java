import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student {
	private String name;
	private String id;
	private String email;

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void anothermethod() {
	}
}

public class ReflectionTest {
	public static void main(String[] args) throws Exception {
		//Class student = Class.forName("Student");
		Method[] methods = Student.class.getDeclaredMethods();

		ArrayList<String> methodList = new ArrayList<>();
		for (int i = 0; i < methods.length; i++) {
			methodList.add(methods[i].getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}
	}

}
