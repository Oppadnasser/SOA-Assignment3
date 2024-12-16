package org.example.app.Models;

import java.util.List;


public class Employee {
    private String FirstName;
    private String LastName;
    private int EmployeeID;
    private String Designation;
    private List<KnownLanguage> KnownLanguages;

    Employee(String FN, String LN, int id , String D){
        this.FirstName = FN;
        this.LastName = LN;
        this.EmployeeID= id;
        this.Designation = D;
    }
    Employee(String FN, String LN, int id , String D,List<KnownLanguage> languages){
        this.FirstName = FN;
        this.LastName = LN;
        this.EmployeeID= id;
        this.Designation = D;
        this.KnownLanguages = languages;
    }
    Employee(){}
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public List<KnownLanguage> getKnownLanguages() {
        return KnownLanguages;
    }

    public void setKnownLanguages(List<KnownLanguage> knownLanguages) {
        KnownLanguages = knownLanguages;
    }
    public void setField(String field , String value){
        switch (field){
            case"firstname":{
                FirstName = value;
                break;
            }
            case"lastname":{
                LastName = value;
                break;
            }
            case"designation":{
                Designation = value;
                break;
            }
        }
    }
}
