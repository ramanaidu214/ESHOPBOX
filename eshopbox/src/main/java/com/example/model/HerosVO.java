package com.example.model;

import java.util.List;

public class HerosVO {
		public int id;
	    public String name;
	    public String localized_name;
	    public String primary_attr;
	    public String attack_type;
	    public List<String> roles;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLocalized_name() {
			return localized_name;
		}
		public void setLocalized_name(String localized_name) {
			this.localized_name = localized_name;
		}
		public String getPrimary_attr() {
			return primary_attr;
		}
		public void setPrimary_attr(String primary_attr) {
			this.primary_attr = primary_attr;
		}
		public String getAttack_type() {
			return attack_type;
		}
		public void setAttack_type(String attack_type) {
			this.attack_type = attack_type;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
	    
}
