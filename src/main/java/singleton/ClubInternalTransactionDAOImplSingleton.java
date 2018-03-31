package singleton;

import dao.ClubInternalTransactionDAOImpl;

public class ClubInternalTransactionDAOImplSingleton {

	private static class SingletonHolder {  
        private static final ClubInternalTransactionDAOImpl INSTANCE = new ClubInternalTransactionDAOImpl();  
    }  
	
    private ClubInternalTransactionDAOImplSingleton (){}  
    
    public static final ClubInternalTransactionDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
