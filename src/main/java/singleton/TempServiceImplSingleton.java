package singleton;

import service.TempServiceImpl;;

public class TempServiceImplSingleton {

	private static class SingletonHolder {  
        private static final TempServiceImpl INSTANCE = new TempServiceImpl();  
    }  
	
    private TempServiceImplSingleton (){}  
    
    public static final TempServiceImpl getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
