package api.fontys.spotifree.Wrappers;

import api.fontys.spotifree.entity.User;

public class WrapperMethod implements IWrapper {

    IWrapper _wrapper;

    public WrapperMethod(IWrapper wrapper) {
        _wrapper = wrapper;
    }
	@Override
	public User UserAuthenticate(User user) {
        _wrapper.UserAuthenticate(user);

		return user;
	}
    
}
