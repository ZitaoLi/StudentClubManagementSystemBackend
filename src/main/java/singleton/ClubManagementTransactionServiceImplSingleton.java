package singleton;

import service.ClubManagementTransactionServiceImpl;

public class ClubManagementTransactionServiceImplSingleton {
	
	private static class SingletonHolder {  
        private static final ClubManagementTransactionServiceImpl INSTANCE = new ClubManagementTransactionServiceImpl();  
    }  
	
    private ClubManagementTransactionServiceImplSingleton (){}  
    
    public static final ClubManagementTransactionServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
