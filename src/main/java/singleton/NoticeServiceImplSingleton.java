package singleton;

import service.NoticeServiceImpl;

public class NoticeServiceImplSingleton {
	
	private static class SingletonHolder {  
        private static final NoticeServiceImpl INSTANCE = new NoticeServiceImpl();  
    }  
	
    private NoticeServiceImplSingleton (){}  
    
    public static final NoticeServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
