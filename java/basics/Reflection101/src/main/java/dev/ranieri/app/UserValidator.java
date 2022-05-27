package dev.ranieri.app;

import java.lang.reflect.Field;

public class UserValidator {

    public static void validate(User user){

        Field [] fields = User.class.getDeclaredFields();

        for(Field f : fields){
            try {

                if(f.isAnnotationPresent(Email.class)){
                    String username = (String) f.get(user);
                    if(!username.contains("@revature.net")){
                        throw new RuntimeException("All usernames must use a @revature.net email address");
                    }

                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
