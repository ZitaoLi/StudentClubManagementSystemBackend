package singleton;

import dao.AdministratorDAOImpl;
import service.ClubInternalTransactionServiceImpl;

public class ClubInternalTransactionServiceImplSingleton {

	private static class SingletonHolder {  
        private static final ClubInternalTransactionServiceImpl INSTANCE = new ClubInternalTransactionServiceImpl();  
    }  
	
    private ClubInternalTransactionServiceImplSingleton (){}  
    
    public static final ClubInternalTransactionServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
