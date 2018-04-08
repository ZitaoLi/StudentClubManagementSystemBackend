package singleton;

import dao.AdministratorDAOImpl;
import service.ClubMemberServiceImpl;

public class ClubMemberServiceImplSingleton {
	
	private static class SingletonHolder {  
        private static final ClubMemberServiceImpl INSTANCE = new ClubMemberServiceImpl();  
    }  
	
    private ClubMemberServiceImplSingleton (){}  
    
    public static final ClubMemberServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
