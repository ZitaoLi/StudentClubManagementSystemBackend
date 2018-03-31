package singleton;

import dao.ClubMemberDAOImpl;

public class ClubMemberDAOImplSingleton {

	private static class SingletonHolder {  
        private static final ClubMemberDAOImpl INSTANCE = new ClubMemberDAOImpl();  
    }  
	
    private ClubMemberDAOImplSingleton (){}  
    
    public static final ClubMemberDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    } 
}
