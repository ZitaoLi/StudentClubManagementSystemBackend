package singleton;

import dao.AdministratorDAOImpl;

public class AdministratorDAOImplSingleton {

	private static class SingletonHolder {  
        private static final AdministratorDAOImpl INSTANCE = new AdministratorDAOImpl();  
    }  
	
    private AdministratorDAOImplSingleton (){}  
    
    public static final AdministratorDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
