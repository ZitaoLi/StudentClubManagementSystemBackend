package singleton;

import dao.NewsCommentDAOImpl;

public class NewsCommentDAOImplSingleton {

	private static class SingletonHolder {  
        private static final NewsCommentDAOImpl INSTANCE = new NewsCommentDAOImpl();  
    }  
	
    private NewsCommentDAOImplSingleton (){}  
    
    public static final NewsCommentDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    } 
}
