package singleton;

import dao.TempDAOImpl;;

public class TempDAOImplSingleton {
	
	private static class SingletonHolder {  
        private static final TempDAOImpl INSTANCE = new TempDAOImpl();  
    }  
	
    private TempDAOImplSingleton (){}  
    
    public static final TempDAOImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
