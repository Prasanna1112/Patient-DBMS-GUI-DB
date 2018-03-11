/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase.pkg5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import static phase.pkg5.Phase5.stmnt;


/**
 *
 * @author SK
 */
public class Phase5 {
   
    public static Connection conn = null;
    static Statement stmnt = null;
    public static int opt;
    public static Scanner kb = new Scanner(System.in);
    
    public static void Connection(){
        try{
                //Establishing database connectivity
               
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","system","system");
		                      
            }catch (SQLException se) { 
                        System.out.println("Connection failed! Check output console."+se.toString());
                }catch(Exception e){
                    System.out.println("Exception in connection:"+e.toString());
                }
                
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Phase5 var = new Phase5();
        Connection();
     
        String choice = "", table = "", col2="", col3="", new_val_str="";
        int supcase = 0, supcase2 = 0, supcase3 = 0, supcase4 = 0;
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(isr);
        
        //Main menu
        do{
            System.out.println("\n-----------Welcome-------------\n");
            System.out.println("Select from the following options: \n");
            System.out.println("1. View tables\n");
            System.out.println("2. Insert values into tables\n");
            System.out.println("3. Delete values from tables\n");
            System.out.println("4. Update values into tables\n");
            System.out.println("5. Generate Reports\n");
            System.out.println("6. Exit");
            
            System.out.println("\n\n\n Enter your choice: ");
            try{
                
                //Reading option selected
                choice = input.readLine();
                supcase = Integer.parseInt(choice);
                
            }catch (NumberFormatException e){
                
                System.out.println("\n Invalid choice!");
                
            }
            try{
                
                switch(supcase){
                    
                    //Display tables
                    case 1:{
                        
                        BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
                        var.Connection();
                        
                        do{
                            System.out.println("\n\n1. Display ACCOUNTANT INFORMATION table\n");
		            System.out.println("2. Display DOCTOR INFORMATION table \n");
		            System.out.println("3. Display DIAGNOSIS DETAILS table \n");
		            System.out.println("4. Display MEDICINE DETAILS table \n");
		            System.out.println("5. Display NURSE INFORMATION table\n");
		            System.out.println("6. Display PATIENT INFORMATION table\n");
		            System.out.println("7. Display PATIENT INSURANCE INFORMATION table\n");
		            System.out.println("8. Display RECEPTIONIST INFORMATION table \n");
		            System.out.println("9. Display PATIENT REGISTRATION DETAILS table \n");
		            System.out.println("10.Display PATIENT TREATMENT DETAILS table \n");
		            System.out.println("11. Previous menu \n");
                            
                            System.out.println("\n\n\n Enter your choice: ");
                          
                            String in2choice = in2.readLine();
                            supcase2 = Integer.parseInt(in2choice);
                            
                            switch(supcase2){
                              
                                case 1:{
                                   var.display_accountantinfo_table();
                                   break;
                                }
                                
                                case 2:{
                                   var.display_doctorinfo_table();
                                   break;
                                }
                                
                                case 3:{
                                   var.display_diagnosisdetails_table();
                                   break;
                                }
                                
                                case 4:{
                                   var.display_medicinedetails_table();
                                   break;
                                }
                                
                                case 5:{
                                   var.display_nurseinfo_table();
                                   break;
                                }
                                
                                case 6:{
                                   var.display_patientinfo_table();
                                   break;
                                }
                                
                                case 7:{
                                   var.display_patientinsuranceinfo_table();
                                   break;
                                }
                                
                                case 8:{
                                   var.display_receptionstinfo_table();
                                   break;
                                }
                                
                                case 9:{
                                   var.display_registrationdetails_table();
                                   break;
                                }
                                
                                case 10:{
                                   var.display_treatmentinfo_table();
                                   break;
                                }
                   
                                case 11:{
                                   break;
                                }
                                
                                default:{
                                    System.out.println("\n\n Wrong Selection!");
                                }
                            }
                        }while(supcase2 != 11); //end of view tables
                        
                       
                        if(supcase2 == 11){
                          continue;
                        }
                }// End of super case 1
               
                        //Insert values in tables
                        case 2:{
                            
                            BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
                            var.Connection();
                        
                        do{
                            
                            System.out.println("\n\n Available tables to insert records into: ");
                            System.out.println("1. ACCOUNTANT INFORMATION table \n");                            
                            System.out.println("2. DOCTOR INFORMATION table \n");
		            
		            System.out.println("3. Previous menu \n");
                         
                            System.out.println("\n\n\n Enter your choice: ");
                            String in3choice = in2.readLine();
                            supcase2 = Integer.parseInt(in3choice);
                            
                            switch(supcase2){
                                
                                case 1:{
                                    
                                    var.insertinto_accttable();
                                    break;
                                }
                                
                                case 2:{
                                    
                                    var.insertinto_doctable();
                                    break;
                                }
                                
                                
                                default:{
                                    
                                    System.out.println("\n\n Wrong selection!");
                                
                                }
                            }
                            
                        }while(supcase2 != 3);
                        
                        if(supcase2 == 3);
                        continue;
                                        
                }// End of super case 2
                            
                        //Delete values from table
                        case 3:{
                            
                            BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
                            var.Connection();
                        
                        do{
                            
                            System.out.println("\n\n Available tables to delete values from : ");
                            System.out.println("1. ACCOUNTANT INFORMATION table \n"); 
                            System.out.println("2. PATIENT INFORMATION table \n");                            
                            System.out.println("3. Previous menu \n");
                         
                            System.out.println("\n\n\n Enter your choice: ");
                            String in3choice = in2.readLine();
                            supcase3 = Integer.parseInt(in3choice);
                            
                            switch(supcase3){
                                
                                //Delete from accountant information table
                                case 1:{
                                    
                                    stmnt = conn.createStatement();
                                    ResultSet rs3 = stmnt.executeQuery("SELECT COUNT(ACC_UNAME) FROM ACCOUNTANT_INFO");
                                    
                                    int count = 0;
                                    while(rs3.next()){
                                        count = rs3.getInt(1);
                                    }
                                    
                                    System.out.println(count);
                                    String[] uniAll = new String[count];
                                  
                                    int ind1 = 0;
                                    ResultSet rsrs = stmnt.executeQuery("SELECT ACC_UNAME FROM ACCOUNTANT_INFO");
              
                                    while(rsrs.next() && ind1 < count){
                                        uniAll[ind1] = rsrs.getString(1);
                                        ind1++;
                                    }
                                    System.out.println("Select Account username you want to delete:");
                                                                     
                                    for (int i= 0; i < uniAll.length; i++){
                                    
                                        System.out.println((i+1)+". "+uniAll[i]);
                                    
                                    }
                                    
                                    System.out.println("Enter your choice:");
                                    String get = in2.readLine();
                                    int acc_uname_index = Integer.parseInt(get);
                                    String tab_name = "ACCOUNTANT_INFO";
                                    
                                    String acc_uname_del = uniAll[acc_uname_index - 1];
                                    String col_name = "ACC_UNAME";
                                    
                                    System.out.println("\n\n Do you want to delete the record with Username:"+acc_uname_del);
                                    System.out.println("\n\n To delete, press Y");
                                    System.out.println("\n\n To abort, press any other key");
                                    String choice2 = input.readLine();
                                    
                                    if (choice2.toString().trim().equalsIgnoreCase("Y")){
                                        
                                        var.delete_table_record(acc_uname_del, tab_name, col_name);
                                        System.out.println("\n\n Record deleted successfully!");
                                        break;
                                    }
                                }// End of delete case 1
                                    
                                
                                //Delete from patient information table
                                case 2:{
                                    
                                    stmnt = conn.createStatement();
                                    ResultSet rs3 = stmnt.executeQuery("SELECT COUNT(PID) FROM PATIENT_INFO");
                                    
                                    int count = 0;
                                    while(rs3.next()){
                                        count = rs3.getInt(1);
                                    }
                                    
                                    System.out.println(count);
                                    String[] uniAll = new String[count];
                                  
                                    int ind1 = 0;
                                    ResultSet rsrs = stmnt.executeQuery("SELECT PID FROM PATIENT_INFO");
              
                                    while(rsrs.next() && ind1 < count){
                                        uniAll[ind1] = rsrs.getString(1);
                                        ind1++;
                                    }
                                    System.out.println("\n\nSelect patient ID you want to delete information of:");
                                                                     
                                    for (int i= 0; i < uniAll.length; i++){
                                    
                                        System.out.println((i+1)+".  "+uniAll[i]);
                                    
                                    }
                                                                        
                                    System.out.println("\n\nEnter your choice:");
                                    String get = in2.readLine();
                                    int pid_index = Integer.parseInt(get);
                                    String tab_name = "PATIENT_INFO";
                                    
                                    String pid_str = uniAll[pid_index - 1];
                                    int pid = Integer.parseInt(pid_str);
                                    String col_name = "PID";
                                    
                                    System.out.println("\n\n Do you want to delete the record with PID: "+pid);
                                    System.out.println("\n\n To delete, press Y");
                                    System.out.println("\n\n To abort, press any other key");
                                    String choice2 = input.readLine();
                                    
                                    if (choice2.toString().trim().equalsIgnoreCase("Y")){
                                        
                                        var.delete_patinet_table_record(pid, tab_name, col_name);
                                        System.out.println("\n\n Record deleted successfully!\n\n");
                                        var.display_patientinfo_table();
                                        break;
                                    }
                                }// End of delete case 2
                                
                                default:
                                    
                                     System.out.println("\n\n Wrong selection!");
                                     break;
                                     
                                  }
                        }while(supcase3 !=3);
                        
                                if(supcase3 == 3)
                                    continue;
                        }// End of super case 3
                        
                        //Update values 
                        case 4:{
                        
                            BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
                            var.Connection();
                            int choice_num = 0, pid = 0;
                            String tab_name = "";
                            String acc_username = "", col_uname = "";
                            String pid_str = "";
                        
                        do{
                            
                            System.out.println("\n\n Available tables to update values of : ");
                            System.out.println("1. ACCOUNTANT INFORMATION table \n");
                            System.out.println("2. PATIENT INFORMATION table \n");
		            System.out.println("3. Previous menu \n");
                         
                            System.out.println("\n\n\n Enter your choice: ");
                            String in3choice = in2.readLine();
                            supcase4 = Integer.parseInt(in3choice);
                            
                            switch(supcase4){
                                
                                //Update values of accountant information table
                                case 1:{
                                    
                                    stmnt = conn.createStatement();
                                    ResultSet rs2 = stmnt.executeQuery("SELECT COUNT(ACC_UNAME) FROM ACCOUNTANT_INFO");
                                    int count = 0;
                                    while(rs2.next()){
                                        count = rs2.getInt(1);
                                    }
                                    
                                    String[] uniAll = new String[count];
                                    int ind = 0;
                                    ResultSet rs = stmnt.executeQuery("SELECT ACC_UNAME FROM ACCOUNTANT_INFO");

                                    while(rs.next() && ind < count){
                                        uniAll[ind] = rs.getString(1);
                                        ind++;
                                        
                                    }
                                    
                                    boolean flag = false;

                                    do{
                                        System.out.println("\n\n Enter accountant username: ");
                                        acc_username = in2.readLine();
                                        
                                        
                                        for(String element : uniAll){
                                            if (element.equalsIgnoreCase(acc_username))
                                            {
                                                flag = false;
                                                break;
                                            }
                                            else{
                                                flag = true;
                                                System.out.println("\n\n Username " + acc_username + " does not exist!");
                                                break;
                                            }

                                        }
                                                
                                    }while(flag != false);
                                    
                                    col_uname= "ACC_UNAME";
                                    tab_name = "ACCOUNTANT_INFO";
                                    System.out.println("\n\n Current values of the Accountant table are:");
                                    var.display_accountantinfo_table();
                                    
                                    int temp = 0;
                                    
                                    System.out.println("\n\n Columns that can be updated are:");
                                    
                                    while(temp == 0){
                                        System.out.println("\n\n 1. Password");
                                        System.out.println("\n\n 2. Salary");
                                        System.out.println("\n\n Enter your choice");
                                        
                                        String choice3 = in2.readLine();
                                        choice_num = Integer.parseInt(choice3);
                                        
                                        if(choice_num == '1' || choice_num == '2')
                                            temp = 1;
                                        break;
                                    }
                                    
                                }
                        
                                    switch(choice_num){
                                        
                                        case 1:{
                                            
                                            String col_pwd = "ACC_PWD";
                                            
                                            System.out.println("Enter the new password value:");
                                            String new_pass_str = in2.readLine();
                                            
                                            var.update_table_record(tab_name, col_uname, acc_username, col_pwd, new_pass_str);
                                            System.out.println("\n\n Record updated successfully!");
                                            var.update_table_record(tab_name, col_uname, acc_username, col_uname, new_pass_str);
                                            break;
                                        }
                                            
                                            
                                        case 2:{
                                            
                                            String col_sal = "SALARY";
                                            
                                            System.out.println("Enter the new salary value:");
                                            String new_sal_str = in2.readLine();
                                            
                                            var.update_table_record(tab_name, col_uname, acc_username, col_sal, new_sal_str);
                                            System.out.println("\n\n Record updated successfully!");
                                            var.update_table_record(tab_name, col_uname, acc_username, col_uname, new_sal_str);
                                            break;
                                        }
                                            
                                    }
                                    continue;
                                    
                                //Update values of patient information table
                                case 2:{
                                    
                                            stmnt = conn.createStatement();
                                            ResultSet rs2 = stmnt.executeQuery("SELECT COUNT(SSN) FROM PATIENT_INFO");
                                            int count = 0;
                                            while(rs2.next()){
                                                count = rs2.getInt(1);
                                            }

                                            String[] uniAll = new String[count];
                                            int ind = 0;
                                            ResultSet rs = stmnt.executeQuery("SELECT PID FROM PATIENT_INFO");

                                            while(rs.next() && ind < count){
                                                uniAll[ind] = rs.getString(1);
                                                ind++;
                                            }

                                            boolean flag = false;

                                            do{
                                                System.out.println("\n\n Enter patient ID: ");
                                                pid_str = in2.readLine();
                                                pid = Integer.parseInt(pid_str);

                                                for(String element : uniAll){
                                                    if (element.equalsIgnoreCase(pid_str))
                                                    {
                                                        flag = false;
                                                        break;
                                                    }
                                                    else{
                                                        flag = true;
                                                        System.out.println("\n\n Patient ID " + pid + " does not exist!");
                                                        break;
                                                    }

                                                }

                                            }while(flag != false);

                                            col_uname= "PID";
                                            tab_name = "PATIENT_INFO";
                                            System.out.println("\n\n Current values of the Patient table are:");
                                            var.display_patientinfo_table();

                                            int temp = 0;

                                            System.out.println("\n\n Columns that can be updated are:");

                                            while(temp == 0){
                                                System.out.println("\n\n 1. Patient phone number");
                                                System.out.println("\n\n 2. Treatment cost");
                                                System.out.println("\n\n Enter your choice");

                                                String choice3 = in2.readLine();
                                                choice_num = Integer.parseInt(choice3);

                                                if(choice_num == '1' || choice_num == '2')
                                                    temp = 1;
                                                break;
                                            }

                                        }

                                            switch(choice_num){

                                                case 1:{

                                                    String col_pwd = "PT_PHONE#";

                                                    System.out.println("Enter the new phone number:");
                                                    String new_pass_str = in2.readLine();

                                                    var.update_patinet_table_record(tab_name, col_uname, pid, col_pwd, new_pass_str);
                                                    System.out.println("\n\n Record updated successfully!");
                                                    var.update_patinet_table_record(tab_name, col_uname, pid, col_uname, new_pass_str);
                                                    break;
                                                }


                                                case 2:{

                                                    String col_sal = "TREATMENT_COST";

                                                    System.out.println("Enter the new treatment cost:");
                                                    String new_sal_str = in2.readLine();

                                                    var.update_patinet_table_record(tab_name, col_uname, pid, col_sal, new_sal_str);
                                                    System.out.println("\n\n Record updated successfully!");
                                                    var.update_patinet_table_record(tab_name, col_uname, pid, col_uname, new_sal_str);
                                                    break;
                                                }

                                        }    
                                    }
                            
                        }while(supcase4 !=3);
                        
                            if(supcase4 == 3)
                                   continue;
                        
                        }//End of super case 4
                
                        //Generate reports
                        case 5:{
                             
                                    BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
                                    var.Connection();
                                    view_query_menu();

                                    do
                                    {
                                        switch (opt) {
                                            
                                            case 1:
                                                {
                                                    System.out.println("Please enter a date in DD-MMM-YY format: ");
                                                    String date = in2.readLine();
                                                    var.view_quarter_billing(date);
                                                    System.out.println("\n");
                                                    break;
                                                }

                                            case 2:
                                                {
                                                    System.out.println("Please enter a date in DD-MMM-YY format: ");
                                                    String date = in2.readLine();
                                                    view_dept_reports(date);
                                                    System.out.println("\n");
                                                    break;
                                                }

                                            case 3:{
                                                total_rev_doc();
                                                System.out.println("\n");
                                                break;
                                            }

                                            case 4:{
                                                num_patients_in_dept();
                                                System.out.println("\n");
                                                break;
                                            }

                                            case 5:{
                                                num_pts_by_docs();
                                                System.out.println("\n");
                                                break;
                                            }

                                            default:
                                                System.out.println("Please select a valid option!");
                                                break;
                                        }

                                            break;
                                    }while(opt != 6);

                                    if(opt == 6)
                                        break;
                            }//End of super case 5
            }
                                             
            }catch(Exception e){
                
                System.out.println(e);
                e.printStackTrace();;
            
        }
        
        
    }while(supcase != 6);
       
               
    }
    
    //view menu for generating reports
    public static void view_query_menu() {
        
		System.out.println("\n\n Please select from the following options");
		
		System.out.println("\n\n 1. VIEW BILLING REPORT FOR A CERTAIN QUARTER");
		System.out.println("\n\n 2. VIEW DEPARTMENT REPORT FOR A CERTAIN QUARTER");
		System.out.println("\n\n 3. VIEW TOTAL REVENUE FOR ALL DOCTORS");
		System.out.println("\n\n 4. VIEW NUMBER OF PATIENTS IN ALL DEPARTMENTS");
		System.out.println("\n\n 5. VIEW NUMBER OF PATIENTS ATTENDED BY EACH DOCTOR");
                System.out.println("\n\n 6. Previous menu");
                
                System.out.println("\n\n Enter your choice:");
		opt = kb.nextInt();
		System.out.println("\n");
	}

	// gets billing info for a certain quarter (3 months)
    private void view_quarter_billing(String date) {
            try {
                        Connection();
			stmnt = conn.createStatement();

			String query = "SELECT RD.DEPARTMENT, SUM(DD.DIAGNOSIS_COST) AS TOTAL_DIAGNOSIS_REVENUE, SUM(PI.TREATMENT_COST) AS TOTAL_TREATMENT_REVENUE FROM ((DIAGNOSIS_DETAILS DD FULL JOIN REGISTRATION_DETAILS RD ON DD.DIG_FK_PID=RD.REG_FK_PID) FULL JOIN PATIENT_INFO PI ON RD.REG_FK_PID=PI.PID) FULL JOIN TREATMENT_DETAILS TD ON TD.TD_FK_PID=PI.PID WHERE TD.TREATMENT_DATE >= TRUNC(ADD_MONTHS('"
					+ date + "',3)) GROUP BY RD.DEPARTMENT ORDER BY TOTAL_DIAGNOSIS_REVENUE,TOTAL_TREATMENT_REVENUE";
			ResultSet rs6 = stmnt.executeQuery(query);

			System.out.println("\n\nDEPARTMENT | TOTAL DIAGNOSIS REVENUE | TOTAL TREATMENT REVENUE");

			while (rs6.next()) {
				System.out.println(rs6.getString(1) + "\t\t" + rs6.getString(2) + "\t\t" + rs6.getString(3));
			}

			stmnt.close();

		} catch (SQLException se) {
			System.out.println(se.toString());
			se.printStackTrace();
		}
        }
	
	// gets department report for a certain quarter (3 months)
    public static void view_dept_reports(String date) {
		try {
		
                        Connection();
                        stmnt = conn.createStatement();

			String query = "SELECT DEPARTMENT, COUNT(REG_FK_PID) AS PATIENT_VOLUME FROM REGISTRATION_DETAILS RD FULL JOIN TREATMENT_DETAILS TD ON RD.REG_FK_PID = TD.TD_FK_PID WHERE TD.TREATMENT_DATE >= TRUNC(ADD_MONTHS('"
					+ date + "',3)) GROUP BY DEPARTMENT ORDER BY PATIENT_VOLUME";
			ResultSet rs = stmnt.executeQuery(query);

			System.out.println("\n\nDEPARTMENT | PATIENT VOLUME");

			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t" + rs.getString(2));
			}

			stmnt.close();
		}

		catch (SQLException se) {
			System.out.println(se.toString());
			se.printStackTrace();
		}
	}

	// gets total revenue for all doctors
    public static void total_rev_doc() {
		try {
			
                        Connection();
                        stmnt = conn.createStatement();
			String query = "SELECT DI.FIRST_NAME,DI.LAST_NAME,SUM(DD.DIAGNOSIS_COST+PI.TREATMENT_COST) AS TOTAL_REVENUE FROM (DIAGNOSIS_DETAILS DD FULL JOIN PATIENT_INFO PI ON PI.PID=DD.DIG_FK_PID) FULL JOIN DOCTOR_INFO DI ON DI.DOC_UNAME=PI.P_FK_DOC_UNAME GROUP BY DI.FIRST_NAME,DI.LAST_NAME ORDER BY TOTAL_REVENUE DESC";
			ResultSet rs = stmnt.executeQuery(query);

			System.out.println("\n\nFIRST NAME  |    LAST NAME    |  TOTAL REVENUE");

			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3));
			}

			stmnt.close();
		}

		catch (SQLException se) {
			System.out.println(se.toString());
			se.printStackTrace();
		}
	}

	// gets number of patients in each department
    public static void num_patients_in_dept() {
		try {
			
                        Connection();
                        stmnt = conn.createStatement();
			String query = "SELECT REG.DEPARTMENT AS DEPARTMENT, COUNT(*) AS TOTAL_PATIENTS FROM REGISTRATION_DETAILS REG JOIN PATIENT_INFO PATIENTS ON REG.REG_FK_PID = PATIENTS.PID AND REG.REG_FK_SSN = PATIENTS.SSN GROUP BY REG.DEPARTMENT";
			ResultSet rs = stmnt.executeQuery(query);

			System.out.println("\n\nDEPARTMENT | TOTAL PATIENTS");

			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t" + rs.getString(2));
			}

			stmnt.close();
		}

		catch (SQLException se) {
			System.out.println(se.toString());
			se.printStackTrace();
		}
	}

	// returns number of patients attended by doctors
    public static void num_pts_by_docs() {
		try {
			
                        Connection();
                        stmnt = conn.createStatement();
			String query = "SELECT DI.FIRST_NAME,DI.LAST_NAME,COUNT(TD.TD_FK_DOC_UNAME) AS NUM_OF_PATIENTS_ATTENDED FROM DOCTOR_INFO DI FULL JOIN TREATMENT_DETAILS TD ON DI.DOC_UNAME=TD.TD_FK_DOC_UNAME GROUP BY DI.FIRST_NAME,DI.LAST_NAME ORDER BY NUM_OF_PATIENTS_ATTENDED DESC";
			ResultSet rs = stmnt.executeQuery(query);

			System.out.println("\n\nFIRST NAME | LAST NAME | NUMBER OF PATIENTS ATTENDED");

			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}

			stmnt.close();
		}

		catch (SQLException se) {
			System.out.println(se.toString());
			se.printStackTrace();
		}
	}

    //display accountant information table
    private void display_accountantinfo_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from accountant_info");
            System.out.println("\n\nUsername   Password   First_name   Last_name   Salary");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }
    
    //display doctor information table
    private void display_doctorinfo_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from doctor_info");
            System.out.println("\n\nUsername   Password   First_name   Last_name   Salary   Specialty   Ph#   Available_date   Available_time   Doc_username");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }

    }

    //display diagnosis details table
    private void display_diagnosisdetails_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from diagnosis_details");
            System.out.println("\n\nCpt_code    Procedure   Cost    Name    Patient_SSN   Patient_id");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    //display medicine details table
    private void display_medicinedetails_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from medicine_details");
            System.out.println("\n\nName    Cost    Dose    Patient_SSN   Patient_id");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    ////display nurse information table
    private void display_nurseinfo_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from nurse_info");
            System.out.println("\n\nUsername   Password   First_name   Last_name   Salary   Specialty   Doc_username");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    //display accountant information table
    private void display_patientinfo_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from patient_info");
            System.out.println("\n\nFirst_name   Last_name   Gender   Ph#   Street   City   State   Zip_code    SSN   Patient_ID   Treatment_name   Treatment_cost   Prescription   Admit_date   Admit_time   Discharge_date    Discharge_time   Doc_username   Nurse_username   Receptionist_username   Accountant_username");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11)+"\t"+rs.getString(12)+"\t"+rs.getString(13)+"\t"+rs.getString(14)+"\t"+rs.getString(15)+"\t"+rs.getString(16)+"\t"+rs.getString(17)+"\t"+rs.getString(18)+"\t"+rs.getString(19)+"\t"+rs.getString(20)+"\t"+rs.getString(21));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    //display patient information table
    private void display_patientinsuranceinfo_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from medicine_details");
            System.out.println("\n\nName    Company    Type    Insurance_id   Patient_SSN   Patient_id");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }
    
    //display receptionist information table
    private void display_receptionstinfo_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from accountant_info");
            System.out.println("\n\nUsername   Password   First_name   Last_name   Salary");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    //display registration details table
    private void display_registrationdetails_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from accountant_info");
            System.out.println("\n\nChief_Complaint   Department   Room#   Mode_of_transport   Patient_SSN   Patient_id");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+rs.getString(6));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    //display treatment information table
    private void display_treatmentinfo_table() {
        
        try{
            stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from accountant_info");
            System.out.println("\n\nTreartment_date   Doc_username   Patient_SSN   Patient_id");
            
            while (rs.next()){
                System.out.println("\n  "+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
            }
                stmnt.close();
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    //Insert vlaues into accountant information table
    private void insertinto_accttable() {
        try{

                        InputStreamReader i = new InputStreamReader(System.in);
                        BufferedReader inp = new BufferedReader(i);

                        String a1, a2, a3, a4, a5, cond1;
                        Boolean b3 = true;

                        stmnt = conn.createStatement();
                        ResultSet rs2 = stmnt.executeQuery("SELECT COUNT(ACC_UNAME) FROM ACCOUNTANT_INFO");
                        int count = 0;
                        while(rs2.next()){
                            count = rs2.getInt(1);
                        }
                        String[] uniAll = new String[count];
                        int ind = 0;
                        ResultSet rs = stmnt.executeQuery("SELECT ACC_UNAME FROM ACCOUNTANT_INFO");
                        
                        while(rs.next() && ind < count){
                            uniAll[ind] = rs.getString(1);
                            ind++;
                                    
                        }
                        
                        boolean flag = false;
                          
                        do{
                            System.out.println("\n\n Enter accountant username: ");
                            a1 = inp.readLine();
                            
                            for(int check=0;check<uniAll.length;check++){
                                if (a1.equalsIgnoreCase(uniAll[check]))
                                {
                                    
                                    flag = true;
                                    System.out.println("\n\n Username " + a1 + " already exists!");
                                    break;
                                    
                                }
                                else{
                                    flag = false;                       
                                }

                            }
                        }while(flag != false);
                        
                            System.out.println("\n\n Enter password: ");
                            a2 = inp.readLine();

                            System.out.println("\n\n Enter first name: ");
                            a3 = inp.readLine();

                            System.out.println("\n\n Enter Last name: ");
                            a4 = inp.readLine();

                            System.out.println("\n\n Enter salary: ");
                            a5 = inp.readLine();
                            float c5 = Float.parseFloat(a5);
                            
                            
                            Connection();
                                String squery = "INSERT INTO ACCOUNTANT_INFO VALUES('"+a1+"','"+a2+"','"+a3+"','"+a4+"',"+c5+")";
                                stmnt = conn.createStatement();
                                stmnt.executeQuery(squery);
                                System.out.println("\n\n Data inserted successfully!");
                                cond1 = inp.readLine();
                                
                                
                            }catch(SQLException e){
                                    System.out.println(e.toString());
                                    e.printStackTrace();
                                    System.out.println("Enter correct values and try again.");
                     
                    }catch(Exception e){
                        System.out.println(e.toString());
                        e.printStackTrace();
                        System.out.println("Enter correct values and try again.");
                    }
        
    }
    
    //Insert into patient information table
    private void insertinto_doctable() {

            try{

                        InputStreamReader i = new InputStreamReader(System.in);
                        BufferedReader inp = new BufferedReader(i);

                        String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, cond;
                        Boolean b3 = true;
                        
                        stmnt = conn.createStatement();
                        ResultSet rs2 = stmnt.executeQuery("SELECT COUNT(ACC_UNAME) FROM DOCTOR_INFO");
                        int count = 0;
                        while(rs2.next()){
                            count = rs2.getInt(1);
                        }
                        String[] uniAll = new String[count];
                        int ind = 0;
                        ResultSet rs = stmnt.executeQuery("SELECT ACC_UNAME FROM DOCTOR_INFO");
                        
                        while(rs.next() && ind < count){
                            uniAll[ind] = rs.getString(1);
                            ind++;
                                    
                        }
                        
                        boolean flag = false;
                          
                        do{
                            System.out.println("\n\n Enter doctor username: ");
                            s1 = inp.readLine();
                            
                            for(int check=0;check<uniAll.length;check++){
                                if (s1.equalsIgnoreCase(uniAll[check]))
                                {
                                    
                                    flag = true;
                                    System.out.println("\n\n Username " + s1 + " already exists!");
                                    break;
                                    
                                }
                                else{
                                    flag = false;                       
                                }

                            }
                        }while(flag != false);
               
                        System.out.println("\n\n Enter password: ");
                            s2 = inp.readLine();

                            System.out.println("\n\n Enter first name: ");
                            s3 = inp.readLine();

                            System.out.println("\n\n Enter Last name: ");
                            s4 = inp.readLine();

                            System.out.println("\n\n Enter salary: ");
                            s5 = inp.readLine();
                            float t5 = Float.parseFloat(s5);
                            
                            System.out.println("\n\n Enter specialty: ");
                            s6 = inp.readLine();

                            System.out.println("\n\n Enter telephone number: ");
                            s7 = inp.readLine();
                            if(s7.length()>10){
                                System.out.println("\n\n Incorrect number!");
                                b3 = false;
                            }
                            else{
                                b3 = true;
                            }

                            System.out.println("\n\n Enter available date: ");
                            s8 = inp.readLine();
                            
                            boolean ch = isValidDate(s8);
                            
                            while(ch == false){
                                System.out.println("\n\nEnter date in correct format! (DD-MMM-YYYY)");
                                s8 = inp.readLine();   
                                
                                ch = isValidDate(s8);
                                System.out.println(ch);
                                if(ch == false){
                                    continue;
                                }
                               
                                    ch = true;
                                    
                            }
               
                            System.out.println("\n\n Enter available time: ");
                            s9 = inp.readLine();

                            boolean ch2 = isValidTime(s9);
                            
                            while(ch2 == false){
                                System.out.println("\n\nEnter time in correct format! (HH:MM) (12hr)");
                                s9 = inp.readLine();   
                                
                                ch2 = isValidTime(s9);
                                System.out.println(ch);
                                if(ch2 == false){
                                    continue;
                                }
                               
                                    ch = true;
                                    
                            }
                            
                            s10 = s1;
                            
                                Connection();
                                String squery = "INSERT INTO DOCTOR_INFO VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"',"+t5+",'"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"')";
                                stmnt = conn.createStatement();
                                stmnt.executeQuery(squery);
                                System.out.println("\n\n Data inserted successfully!");
                                cond = inp.readLine();

                        }catch(SQLException e){
                                    System.out.println(e.toString());
                                    e.printStackTrace();
                                    System.out.println("Enter correct values and try again.");
                     
                    }catch(Exception e){
                        System.out.println(e.toString());
                        e.printStackTrace();
                        System.out.println("Enter correct values and try again.");
                    }
                }
    
    //User input Date validation
    public static boolean isValidDate(String inDate) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            dateFormat.setLenient(false);
            try {
              dateFormat.parse(inDate.trim());
            } catch (ParseException pe) {
              return false;
            }
            return true;
          }
    
    //User inpot time validation
    public static boolean isValidTime(String inTime) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
            dateFormat.setLenient(false);
            try {
              dateFormat.parse(inTime.trim());
            } catch (ParseException pe) {
              return false;
            }
            return true;
          }
    
    //delete values from accountant information table
    private void delete_table_record(String val_del, String table, String column_name) {
        
        try 
		{
			stmnt = conn.createStatement();
			
			stmnt.executeQuery("DELETE FROM " +table+ " WHERE " +column_name+ " = " + "'" +val_del+ "'");
			
			stmnt.close();
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
        
    }
    
    //delete values from patient information table
    private void delete_patinet_table_record(int pid, String tab_name, String col_name) {
        
         try 
		{
			stmnt = conn.createStatement();
			
			stmnt.executeQuery("DELETE FROM " +tab_name+ " WHERE " +col_name+ " = " +pid);
			
			stmnt.close();
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
        
    }


    //Update vlaues of accountant information table
    private void update_table_record(String table_name,String column_uname,String accountant_username,String column_update,String new_update_string) {
           
        try 
		{
			stmnt = conn.createStatement();
			
			stmnt.executeQuery("UPDATE " +table_name+  " SET " +column_update+ " = '" +new_update_string+ "' WHERE " +column_uname+  " = " + "'" +accountant_username+ "'" );
			
			stmnt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
    }

    //Update values of patient information table
    private void update_patinet_table_record(String tab_name, String col_uname, int pid, String col_update, String new_update_str) {
        
        try 
		{
			stmnt = conn.createStatement();
			
			stmnt.executeQuery("UPDATE " +tab_name+  " SET " +col_update+ " = '" +new_update_str+ "' WHERE " +col_uname+  " = "  +pid );
			
			stmnt.close();
			
		} 
		
		catch (SQLException e) 
		{
			System.out.println(e.toString());
		}
    }

}




