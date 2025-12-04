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

    public static boolean isDepartmentNameValid(String departmentName) {
        if(departmentName == null || departmentName.isEmpty()){
            return false;
        }

        for(int i =0; i< departmentName.length(); i++){
            char c = departmentName.charAt(i);

            if(!Character.isDigit(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        if(isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
            this.departmentId = String.format("D%02d",nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }
}
