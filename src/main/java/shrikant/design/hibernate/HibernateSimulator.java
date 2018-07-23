//package shrikant.design.hibernate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class HibernateSimulator {
//    // Question :: you have to write a simple program which will emulate hibernate like capabilities
//    public static void main(String[] args) {
//        Employee employee = new Employee();
//
//        Class employeeClass = employee.getClass();
//
//        List<String> dataFromFile = new ArrayList<String>();
//        dataFromFile.add("PersoneOne,10");
//        dataFromFile.add("PersoneTwo,20");
//
//        while (String line : dataFromFile){
//
//        }
//    }
//}
//
//
//enum EmployeeColumns{
//    NAME("name", 0),
//    SALARY("salary",1);
//
//    EmployeeColumns(String property, int index) {
//        this.property = property;
//        this.index = index;
//    }
//
//    private String property;
//    private int index;
//
//    public String getProperty() {
//        return property;
//    }
//
//    public int getIndex() {
//        return index;
//    }
//}