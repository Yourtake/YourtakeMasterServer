package com.zapang.test;






import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.dao.OrganizationDAO;
import com.yourtake.model.dao.TeamDAO;
import com.yourtake.model.dao.UserDAO;
import com.yourtake.model.dao.ViewDAO;
import com.yourtake.model.util.HibernateUtil;
import org.hibernate.SessionFactory;


/**
 *
 * @author Welcome
 */
public class AdvancedTest {
   
    public static void main(String[] args) {
       
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        GenericDAO dao= new OrganizationDAO();
        dao.setFactory(factory);
        dao= new UserDAO();
        dao.setFactory(factory);
        dao= new ViewDAO();
        dao.setFactory(factory);
        dao= new TeamDAO();
        dao.setFactory(factory);
        
        
        
        
        
     
        
        
    }
}
