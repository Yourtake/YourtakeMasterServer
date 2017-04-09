package com.yourtake.init;






import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.dao.setup.BranchDAO;
import com.yourtake.model.dao.setup.ContactDAO;
import com.yourtake.model.dao.setup.OrganizationDAO;
import com.yourtake.model.dao.setup.RuleDAO;
import com.yourtake.model.dao.users.TeamDAO;
import com.yourtake.model.dao.users.IndividualDAO;
import com.yourtake.model.dao.views.FooterDAO;
import com.yourtake.model.dao.views.FormInputDAO;
import com.yourtake.model.dao.views.HeaderDAO;
import com.yourtake.model.dao.views.PageDAO;
import com.yourtake.model.dao.views.TabDAO;
import com.yourtake.model.dao.views.ViewDAO;
import com.yourtake.model.pojo.users.Individual;
import com.yourtake.model.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;


/**
 *
 * @author Welcome
 */
public class DBInit {
   
    public static void main(String[] args) {
       
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        GenericDAO dao= new OrganizationDAO();
        dao.setSessionFactory(factory);
        dao= new ContactDAO();
        dao.setSessionFactory(factory);
        dao= new BranchDAO();
        dao.setSessionFactory(factory);
        dao= new RuleDAO();
        dao.setSessionFactory(factory);
        
        dao= new IndividualDAO();
        dao.setSessionFactory(factory);
        
            Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        dao.create(new Individual("support@yourtake.in",encoder.encodePassword("abcdef", null),"Admin",0));
        dao= new TeamDAO();
        dao.setSessionFactory(factory);
        
        dao= new ViewDAO();
        dao.setSessionFactory(factory);
        dao= new FooterDAO();
        dao.setSessionFactory(factory);
        dao= new FormInputDAO();
        dao.setSessionFactory(factory);
        dao= new HeaderDAO();
        dao.setSessionFactory(factory);
        dao= new TabDAO();
        dao.setSessionFactory(factory);
        dao= new PageDAO();
        dao.setSessionFactory(factory);
        
        
        
        
        
        
     
        
        
    }
}
