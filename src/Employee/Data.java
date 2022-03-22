package Employee;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Data {

    private void register() throws FileNotFoundException
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);

        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Password_verification pv = new Password_verification();
        String ConPass = "";
        try {
            Password_verification.isValid(Pass);
            System.out.println("Valid Password");
            System.out.println("Confirm Password: ");
            ConPass=sc.nextLine();
            System.out.println(ConPass);
            Uname=Uname.trim();
            Pass=Pass.trim();
            ConPass=ConPass.trim();
        }
        catch (InvalidPasswordException e) {
            System.out.print(e.getMessage());
            System.out.println(e.printMessage());
            System.out.println("Try again");
            Data data = new Data();
            data.register();
        }


        String x= Uname+" "+Pass;
        if(Pass.equals(ConPass))
        {

            File f = new File("src\\Registration.txt");
            Scanner content = new Scanner(f);


            int flag=0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Already Registered");
                    flag=1;
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");

                    System.out.println("Enter your Choice");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        this.register();
                    }
                    else if(choice==2)
                    {
                        this.login();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
            }
            if(flag==0)
            {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("src\\Registration.txt", true));
                    out.write(Uname+" "+Pass+"\n");
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("exception occurred" + e);
                }

                System.out.println("Successfully Registered");
                System.out.println("Please login");
                this.login();
            }


        }
        else
        {
            System.out.println("Recheck");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");

            System.out.println("Enter your Choice");
            int choice=sc.nextInt();
            if(choice==1)
            {
                this.register();
            }
            else if(choice==2)
            {
                this.login();
            }
            else
            {
                System.out.println("Choose Proper Option");
            }
        }
        sc.close();
    }

    public void login()
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Login page");
        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);

        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;


        try {

            File f = new File("src\\Registration.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Login Successful");
                    System.out.println("Welcome to the Application.");
                    flag=1;
                    new EmployeeManagement();
                    EmployeeManagement.main(null);
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Login Failed");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");

                System.out.println("Enter your Choice");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    this.register();
                }
                else if(choice==2)
                {
                    this.login();
                }
                else
                {
                    System.out.println("Choose Proper Option");
                }
            }

            content.close();
        }
        catch (FileNotFoundException e) {


            System.out.println("Error.");
            e.printStackTrace();
        }

        sc.close();
    }

    public static void main(String[] args) throws FileNotFoundException{

        try {

            File obj = new File("src\\Registration.txt");

            if (obj.createNewFile())
            {
                System.out.println("File is created");
            }

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("******Welcome to User Database******");
        System.out.println("1. Registration. ");
        System.out.println("2. Login. ");

        System.out.println("Enter your Choice");
        choice=sc.nextInt();
        sc.nextLine();

        if(choice==1)
        {
            Data user = new Data();
            user.register();
        }
        else if(choice==2)
        {
            Data user = new Data();
            user.login();
        }
        else
        {
            System.out.println("Choose Proper Option");
        }
        sc.close();
    }
}
class InvalidPasswordException extends Exception {

    int passwordConditionViolated = 0;

    public InvalidPasswordException(int conditionViolated)
    {
        super("Invalid Password: ");
        passwordConditionViolated = conditionViolated;
    }

    public String printMessage()
    {
        switch (passwordConditionViolated) {

            case 1:
                return ("Password length should be between 8 to 15 characters");

            case 2:
                return ("Password should contain at least one digit(0-9)");

            case 3:
                return ("Password should contain at least one special character");

            case 4:
                return ("Password should contain at least one uppercase letter(A-Z)");

            case 5:
                return ("Password should contain at least one lowercase letter(a-z)");
        }

        return ("");
    }
}

class Password_verification {

    public static void isValid(String password)
            throws InvalidPasswordException
    {
        if (!((password.length() >= 8)
                && (password.length() <= 15))) {
            throw new InvalidPasswordException(1);
        }

        if (true) {
            int count = 0;
            for (int i = 0; i <= 9; i++) {
                String str1 = Integer.toString(i);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(2);
            }
        }
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            throw new InvalidPasswordException(3);
        }

        if (true) {
            int count = 0;
            for (int i = 65; i <= 90; i++) {
                char c = (char)i;

                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(4);
            }
        }

        if (true) {
            int count = 0;
            for (int i = 90; i <= 122; i++) {
                char c = (char)i;
                String str1 = Character.toString(c);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(5);
            }
        }
    }
}

//Once User Logged In

@SuppressWarnings("serial")
class Employee implements Serializable{

    String user_id;
    String name;
    int age;
    String CompanyName;
    String Designation;
    float salary;
    long contact_no;
    String Address;

    public Employee(String user_id, String name, int age, String CompanyName, String Designation, float salary, long contact_no, String Address)
    {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.CompanyName = CompanyName;
        this.Designation = Designation;
        this.salary = salary;
        this.contact_no = contact_no;
        this.Address = Address;
    }

    public String toString()
    {
        return "\nEmployee Details :" + "\nID: " + this.user_id + "\nName: " + this.name + "\nAge:" + "\nCompany Name:" + this.CompanyName + this.age + "\nDesignation:" + this.Designation + "\nSalary: " +
                this.salary + "\nContact No: " + this.contact_no + "\nAddress: " + this.Address;
    }

}

class EmployeeManagement
{
    static void display(ArrayList<Employee> al)
    {
        System.out.println("\n----------- User database records ------------------ \n");
        System.out.println(String.format("%-10s%-15s%-%-10s%-15s%-15s%-10s%-20s%-10s", "ID","Name","Age","Company Name","Designation","salary","contact-no","Address"));
        for(Employee e : al)
        {
            System.out.println(String.format("%-10s%-15s%-%-10s%-15s%-15s%-10s%-20s%-10s",e.user_id,e.name,e.age,e.CompanyName,e.Designation,e.salary,e.contact_no,e.Address));
        }
    }

    static String uniqueID(){
        final String uniqueKey = UUID.randomUUID().toString();
        return uniqueKey;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        String user_id;
        String name;
        int age;
        String CompanyName;
        String Designation;
        float salary;
        long contact_no;
        String Address;

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> al = new ArrayList<Employee>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos =null;
        try{

            f = new File("src\\EmployeeDataList.txt");
            if(f.exists())
            {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                al = (ArrayList<Employee>)ois.readObject();
            }

        }
        catch(Exception exp){
            System.out.println(exp);
        }
        do
        {
            System.out.println("\n******Welcome to User Database****** \n");
            System.out.println("1). Add Employee to the DataBase\n" +
                    "2). Edit Employee details\n" +
                    "3). Delete Employee Details\n" +
                    "4). Display all Employees working in this company\n" +
                    "5). EXIT\n");
            System.out.println("Enter your choice : ");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:System.out.println("\nAdd the User Data for the Following fields:\n");
                    System.out.println("Your user ID is :");
                    user_id = uniqueID();
                    System.out.println("Enter Name :");
                    name = sc.next();
                    System.out.println("Enter Age :");
                    age = sc.nextInt();
                    if(age<18 || age > 90){
                        System.out.println("Age cannot be less than 18 or greater than 90");
                        System.out.println("Please re-enter age");
                        age =sc.nextInt();
                    }
                    System.out.println("Enter Company Name :");
                    CompanyName = sc.nextLine();
                    System.out.println("Enter Designation :");
                    Designation = sc.nextLine();
                    System.out.println("Enter Salary :");
                    salary = sc.nextFloat();
                    if(salary <= 0){
                        System.out.println("Salary cannot be zero or less than zero");
                        System.out.println("Please re-enter salary");
                        salary = sc.nextFloat();
                    }
                    System.out.println("Enter Contact No :");
                    contact_no = sc.nextLong();
                    if(contact_no/1000000000>=10){
                        System.out.println("Contact number cannot be more than 10 digits");
                        System.out.println("Please re-enter contact number");
                        contact_no = sc.nextLong();
                    }
                    System.out.println("Enter Address :");
                    Address = sc.next();
                    al.add(new Employee(user_id, name, age, CompanyName, Designation, salary, contact_no, Address));
                    display(al);
                    break;

                case 2: try {
                    al = (ArrayList<Employee>)ois.readObject();

                    } catch (ClassNotFoundException e2) {

                        System.out.println(e2);
                    } catch (Exception e2) {

                        System.out.println(e2);
                    }
                        display(al);
                        break;

                case 3: System.out.println("\nPlease enter the field that needs to be updated");
                    user_id = sc.nextLine();
                    int j=0;
                    for(Employee e: al)
                    {
                        if(user_id == e.user_id)
                        {
                            j++;
                            do{
                                int ch1 =0;
                                System.out.println("\nUpdate Employee Details :\n" +
                                        "1). Name\n" +
                                        "2). Age" +
                                        "3). Company Name" +
                                        "4). Designation" +
                                        "5). Salary\n" +
                                        "6). Contact No.\n" +
                                        "7). Email-ID\n" +
                                        "8). GO BACK\n");
                                ch1 = sc.nextInt();
                                switch(ch1)
                                {
                                    case 1: System.out.println("Update Employee Name:");
                                        e.name =sc.nextLine();
                                        System.out.println(e+"\n");
                                        break;

                                    case 2: System.out.println("Update Employee Age:");
                                        e.age =sc.nextInt();
                                        if(e.age<18 || e.age > 90){
                                            System.out.println("Age cannot be less than 18 or greater than 90");
                                            System.out.println("Please re-enter age");
                                            e.age =sc.nextInt();
                                        }
                                        System.out.println(e+"\n");
                                        break;

                                    case 3: System.out.println("Update Employee Company:");
                                        e.CompanyName =sc.nextLine();
                                        System.out.println(e+"\n");
                                        break;

                                    case 4: System.out.println("Update Employee Designation:");
                                        e.Designation =sc.nextLine();
                                        System.out.println(e+"\n");
                                        break;

                                    case 5: System.out.println("Update Employee Salary:");
                                        e.salary =sc.nextFloat();
                                        if(e.salary <= 0){
                                            System.out.println("Salary cannot be zero or less than zero");
                                            System.out.println("Please re-enter salary");
                                            e.salary = sc.nextFloat();
                                        }
                                        System.out.println(e+"\n");
                                        break;

                                    case 6: System.out.println("Update Employee Contact number:");
                                        e.contact_no =sc.nextLong();
                                        if(e.contact_no/1000000000>=10){
                                            System.out.println("Contact number cannot be more than 10 digits");
                                            System.out.println("Please re-enter contact number");
                                            e.contact_no = sc.nextLong();
                                        }
                                        System.out.println(e+"\n");
                                        break;

                                    case 7: System.out.println("Update Employee Address:");
                                        e.Address =sc.next();
                                        System.out.println(e+"\n");
                                        break;

                                    case 8: j++;
                                        break;

                                    default : System.out.println("\nEnter a correct choice from the List :");
                                        break;

                                }
                            }
                            while(j==1);
                        }
                    }
                    if(j == 0)
                    {
                        System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
                    }

                    break;

                case 4: System.out.println("\nENTER THE RECORD THAT NEEDS TO BE DELETED :");
                    user_id = sc.nextLine();
                    int k=0;
                    try{
                        for(Employee e: al)
                        {
                            if(user_id == e.user_id)
                            {
                                al.remove(e);
                                display(al);
                                k++;
                            }
                        }
                        if(k == 0)
                        {
                            System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
                        }
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                    break;

                case 5: try {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(al);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                catch(Exception e2){
                    e2.printStackTrace();
                }
                finally{
                    try {
                        fis.close();
                        fos.close();
                        oos.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
                    System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");
                    sc.close();
                    System.exit(0);
                    break;

                default : System.out.println("\nEnter a correct choice from the List :");
                    break;

            }
        }
        while(true);
    }

}
