package com.dns.springboot3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dns.springboot3.entities.AppUser;
import com.dns.springboot3.repositories.AppRoleRepository;
import com.dns.springboot3.repositories.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserREP;
	@Autowired 
	private AppRoleRepository appRoleREP;
	@Override
	public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException{
		AppUser appUser = this.appUserREP.findUserAccount(userName);
		if( appUser== null) {
			System.out.println("User not found " + userName);
			throw new UsernameNotFoundException("User" + userName + "was not found in the DB");
		}
		System.out.println("Found User : " + appUser);
		List<String> roleNames = this.appRoleREP.getRoleNames(appUser.getUserId());
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		if(roleNames != null) {
			for(String role : roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);
		return userDetails;
	}
	
}
