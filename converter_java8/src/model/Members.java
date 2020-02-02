package model;

import java.util.ArrayList;
import java.util.List;

public class Members {

	private List<Member> members;
    
    public List<Member> getMembers() {
        if(this.members == null) {
        	this.members = new ArrayList<>();
        }
        return this.members;
    }
  
    public void setEmployeeList(List<Member> members) {
        this.members = members;
    }

}
