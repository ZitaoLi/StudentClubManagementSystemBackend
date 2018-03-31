package singleton;

import service.UserServiceImpl;

public class UserServiceImplSingleton {

	private static class SingletonHolder {  
        private static final UserServiceImpl INSTANCE = new UserServiceImpl();  
    }  
	
    private UserServiceImplSingleton (){}  
    
    public static final UserServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
