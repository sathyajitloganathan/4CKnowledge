package it16139404;

public class UserBean {
	
	private String username;
    private String password;
    private String name;
    private String type;
    public boolean valid;
	
	
    public String getName() {
        return name;
	}

    public void setName(String newName) {
        name = newName;
	}
			

    public String getPassword() {
        return password;
	}

    public void setPassword(String newPassword) {
        password = newPassword;
	}
	
			
    public String getUsername() {
        return username;
			}

    public void setUserName(String newUsername) {
        username = newUsername;
			}
    
    public String getType() {
        return type;
	}

    public void setType(String newType) {
        type = newType;
	}
				
    public boolean isValid() {
        return valid;
	}

    public void setValid(boolean newValid) {
        valid = newValid;
	}	
     
}
