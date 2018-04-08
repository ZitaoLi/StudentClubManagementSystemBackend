package factory;

import dao.GenericDAO;
import singleton.AdministratorDAOImplSingleton;
import singleton.AdministratorTransactionDAOImplSingleton;
import singleton.ClubDAOImplSingleton;
import singleton.ClubInternalTransactionDAOImplSingleton;
import singleton.ClubManagementTransactionDAOImplSingleton;
import singleton.ClubMemberDAOImplSingleton;
import singleton.NewsCommentDAOImplSingleton;
import singleton.NewsDAOImplSingleton;
import singleton.NoticeDAOImplSingleton;
import singleton.TempDAOImplSingleton;
import singleton.UserDAOImplSingleton;

public class DAOFactory {

	public static final String TAG = "DAOFactory";
    public static GenericDAO getDAOImpl(String type) {
        GenericDAO daoImpl = null;
        if (type.equalsIgnoreCase("AdministratorDAOImpl")) {
        	daoImpl = AdministratorDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("AdministratorTransactionDAOImpl")) {
            daoImpl = AdministratorTransactionDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("ClubDAOImpl")) {
        	daoImpl = ClubDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("ClubInternalTransactionDAOImpl")) {
        	daoImpl = ClubInternalTransactionDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("ClubManagementTransactionDAOImpl")) {
        	daoImpl = ClubManagementTransactionDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("ClubMemberDAOImpl")) {
        	daoImpl = ClubMemberDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("NewsCommentDAOImpl")) {
        	daoImpl = NewsCommentDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("NewsDAOImpl")) {
        	daoImpl = NewsDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("NoticeDAOImpl")) {
        	daoImpl = NoticeDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("UserDAOImpl")) {
        	daoImpl = UserDAOImplSingleton.getInstance();
        } else if (type.equalsIgnoreCase("TempDAOImpl")) {
        	daoImpl = TempDAOImplSingleton.getInstance();
        }
        return daoImpl;
    }
}
