package org.riyad;

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

}
