package com.lonely.wolf.note.clone;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/22
 * @since jdk1.8
 */
public class CloneTest implements Cloneable{
    private String name;
    private Employee employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        try {
            CloneTest cloneTest = new CloneTest();
            Employee employee = cloneTest.new Employee();
            employee.setAddress("111");
            cloneTest.setEmployee(employee);
            CloneTest cloneTest1 = (CloneTest) cloneTest.clone();
            cloneTest1.getEmployee().setAddress("222");
            System.out.println(cloneTest.getEmployee());
            System.out.println(cloneTest.getEmployee().getAddress());
            System.out.println(cloneTest1.getEmployee());
            System.out.println(cloneTest1.getEmployee().getAddress());
        }catch (Exception e){
            System.out.println(222);
        }
    }


    class Employee{
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
