/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yourtake.service;


import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.users.Individual;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class LoginService implements UserDetailsService {
     
     @Autowired
     @Qualifier("individualDao") 
    private GenericDAO individualDAO;   
    private Individual domainUser;
    
    
 
    @Override
    public UserDetails loadUserByUsername(String login)throws UsernameNotFoundException, DataAccessException {


           domainUser = (Individual) individualDAO.read("id",new Individual(login));
            try{
                domainUser.getEmail();
                domainUser.getPassword();
            }
            catch(Exception e){
                System.out.println("Error in Admin Login Service");
            }
         
         
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        return new User(
                domainUser.getEmail(), 
                domainUser.getPassword(), 
                enabled, 
                accountNonExpired, 
                credentialsNonExpired, 
                accountNonLocked,
                getAuthorities()
        );
    }
     
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles());
        return authList;
    }
     
    public List<String> getRoles() {
 
        List<String> roles = new ArrayList<>();
        try{
         roles.add(domainUser.getMyRole());
        
        }
        catch(Exception e){
              System.out.println("Error in Admin fetching role");
        }
        
        return roles;
    }
     
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
         
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
 
}