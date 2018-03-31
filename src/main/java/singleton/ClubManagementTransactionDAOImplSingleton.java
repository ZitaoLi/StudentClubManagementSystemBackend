package singleton;

import dao.ClubManagementTransactionDAOImpl;

public class ClubManagementTransactionDAOImplSingleton {

	private static class SingletonHolder {  
        private static final ClubManagementTransactionDAOImpl INSTANCE = new ClubManagementTransactionDAOImpl();  
    }  
	
    private ClubManagementTransactionDAOImplSingleton (){}  
    
    public static final ClubManagementTransactionDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    } 
}
