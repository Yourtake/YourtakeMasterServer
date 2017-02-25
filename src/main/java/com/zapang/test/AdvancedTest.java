package com.zapang.test;





import com.yourtake.model.dao.AdminDAOImpl;
import com.yourtake.model.dao.ClientDAOImpl;
import com.yourtake.model.pojo.Admin;
import com.yourtake.model.util.HibernateUtil;


/**
 *
 * @author Welcome
 */
public class AdvancedTest {
   
    public static void main(String[] args) {
       
        AdminDAOImpl adao = new AdminDAOImpl();
        ClientDAOImpl cdao = new ClientDAOImpl();
        adao.setSessionFactory(HibernateUtil.getSessionFactory());
        cdao.setSessionFactory(HibernateUtil.getSessionFactory());
        adao.setSessionFactory(HibernateUtil.getSessionFactory());
        adao.getSessionFactory().openSession();
        adao.buildInitEntity(new Admin("support@zapang.com","abcdef","ROLE_ADMINISTRATOR","Support",0,"Administrator"));
//            

        
        
     
        
        
    }
}
