package singleton;

import dao.UserDAOImpl;

public class UserDAOImplSingleton {

	private static class SingletonHolder {  
        private static final UserDAOImpl INSTANCE = new UserDAOImpl();  
    }  
	
    private UserDAOImplSingleton (){}  
    
    public static final UserDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    } 
}
