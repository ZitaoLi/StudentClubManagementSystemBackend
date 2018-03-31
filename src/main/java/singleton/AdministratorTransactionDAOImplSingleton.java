package singleton;

import dao.AdministratorTransactionDAOImpl;

public class AdministratorTransactionDAOImplSingleton {

	private static class SingletonHolder {  
        private static final AdministratorTransactionDAOImpl INSTANCE = new AdministratorTransactionDAOImpl();  
    }  
	
    private AdministratorTransactionDAOImplSingleton (){}  
    
    public static final AdministratorTransactionDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
