package factory;

import service.ClubManagementTransactionServiceImpl;
import service.GenericService;
import singleton.ClubInternalTransactionServiceImplSingleton;
import singleton.ClubManagementTransactionServiceImplSingleton;
import singleton.ClubMemberServiceImplSingleton;
import singleton.ClubServiceImplSingleton;
import singleton.NewsServiceImplSingleton;
import singleton.NoticeServiceImplSingleton;
import singleton.TempServiceImplSingleton;
import singleton.UserServiceImplSingleton;

public class ServiceFactory {

	public static final String TAG = "DAOFactory";
    public static GenericService loadServiceImpl(String type) {
    	GenericService serviceImpl = null;
        if (type.equalsIgnoreCase("ClubServiceImpl")) {
        	serviceImpl = ClubServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("UserServiceImpl")) {
        	serviceImpl = UserServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("ClubMemberServiceImpl")) {
        	serviceImpl = ClubMemberServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("NewsServiceImpl")) {
        	serviceImpl = NewsServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("ClubInternalTransactionServiceImpl")) {
        	serviceImpl = ClubInternalTransactionServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("NoticeServiceImpl")) {
        	serviceImpl = NoticeServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("TempServiceImpl")) {
        	serviceImpl = TempServiceImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("ClubManagementTransactionServiceImpl")) {
        	serviceImpl = ClubManagementTransactionServiceImplSingleton.getInstance();
        }
        return serviceImpl;
    }
}
