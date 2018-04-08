package singleton;

import dao.AdministratorDAOImpl;
import service.NewsServiceImpl;

public class NewsServiceImplSingleton {

	private static class SingletonHolder {  
        private static final NewsServiceImpl INSTANCE = new NewsServiceImpl();  
    }  
	
    private NewsServiceImplSingleton (){}  
    
    public static final NewsServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
