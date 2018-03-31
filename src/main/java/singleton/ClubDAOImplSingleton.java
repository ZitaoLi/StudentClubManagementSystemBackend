package singleton;

import dao.ClubDAOImpl;

public class ClubDAOImplSingleton {
	
	private static class SingletonHolder {  
        private static final ClubDAOImpl INSTANCE = new ClubDAOImpl();  
    }  
	
    private ClubDAOImplSingleton (){}  
    
    public static final ClubDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
