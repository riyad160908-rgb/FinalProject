package org.riyad;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;

    private static int nextId = 1;

    /**
     * checks if a department name is valid or not,
     * a department name should only contain letters or spaces
     * @param departmentName the name of the department
     * @return true if valid, false otherwise
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if(departmentName == null || departmentName.isEmpty()){
            return false;
        }

        for(int i = 0; i< departmentName.length(); i++){
            char c = departmentName.charAt(i);

            if(!Character.isDigit(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        if(isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
            this.departmentId = String.format("D%02d",nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if(isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        }
    }
}
