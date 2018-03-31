package singleton;

import dao.NewsDAOImpl;

public class NewsDAOImplSingleton {

	private static class SingletonHolder {  
        private static final NewsDAOImpl INSTANCE = new NewsDAOImpl();  
    }  
	
    private NewsDAOImplSingleton (){}  
    
    public static final NewsDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    } 
}
