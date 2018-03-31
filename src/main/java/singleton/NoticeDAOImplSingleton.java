package singleton;

import dao.NoticeDAOImpl;

public class NoticeDAOImplSingleton {

	private static class SingletonHolder {  
        private static final NoticeDAOImpl INSTANCE = new NoticeDAOImpl();  
    }  
	
    private NoticeDAOImplSingleton (){}  
    
    public static final NoticeDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    } 
}
