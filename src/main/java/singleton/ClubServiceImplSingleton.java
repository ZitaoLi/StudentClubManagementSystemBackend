package singleton;

import service.ClubServiceImpl;

public class ClubServiceImplSingleton {

	private static class SingletonHolder {  
        private static final ClubServiceImpl INSTANCE = new ClubServiceImpl();  
    }  
	
    private ClubServiceImplSingleton (){}  
    
    public static final ClubServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
