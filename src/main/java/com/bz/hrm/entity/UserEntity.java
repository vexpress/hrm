package com.bz.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserEntity{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(unique = true, nullable = false)
	 
	 private String username;
	 
	 @Column(nullable = false)
	 
	 private String password; 
	 
	  @ManyToMany(fetch = FetchType.EAGER)
	  @JoinTable(
	        name = "user_roles",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id")
	  )
	  private Set<RoleEntity> roles = new HashSet<>();
	
	  public Long getId() {
		    return this.id;
		}
		public String getUsername() {
		    return this.username;
		}
		public String getPassword() {
		    return this.password;
		}
		public Set<RoleEntity> getRoles() {
		    return this.roles;
		}

}