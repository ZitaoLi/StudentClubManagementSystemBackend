package factory;

import service.GenericService;
import singleton.ClubServiceImplSingleton;
import singleton.UserServiceImplSingleton;

public class ServiceFactory {

	public static final String TAG = "DAOFactory";
    public static GenericService loadServiceImpl(String type) {
    	GenericService serviceImpl = null;
        if (type.equalsIgnoreCase("ClubServiceImpl")) {
        	serviceImpl = ClubServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("UserServiceImpl")) {
        	serviceImpl = UserServiceImplSingleton.getInstance();
        }
        return serviceImpl;
    }
}
