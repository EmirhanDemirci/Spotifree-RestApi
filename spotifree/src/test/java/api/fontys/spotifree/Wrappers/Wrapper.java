package api.fontys.spotifree.Wrappers;

import api.fontys.spotifree.entity.User;

public class Wrapper {
    
    public boolean AuthenticateUser(User user) {
        Boolean data = UserTestData(user.getUsername(), user.getPassword());

        if (data == true) {
            return true;
        }
        else
        {
            return false;
        } 
    }

    public boolean UserTestData(String username, String password)
    {
        String _username = "emirhan123";
        String _password = "test1234";

        if (_username == username && _password == password)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
