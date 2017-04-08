package com.yourtake.init;






import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.dao.setup.OrganizationDAO;
import com.yourtake.model.dao.users.TeamDAO;
import com.yourtake.model.dao.users.IndividualDAO;
import com.yourtake.model.dao.views.ViewDAO;
import com.yourtake.model.util.HibernateUtil;
import org.hibernate.SessionFactory;


/**
 *
 * @author Welcome
 */
public class DBInit {
   
    public static void main(String[] args) {
       
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        GenericDAO dao= new OrganizationDAO();
        dao.setSessionFactory(factory);
        dao= new IndividualDAO();
        dao.setSessionFactory(factory);
        dao= new ViewDAO();
        dao.setSessionFactory(factory);
        dao= new TeamDAO();
        dao.setSessionFactory(factory);
        
        
        
        
        
     
        
        
    }
}
