import java.lang.classfile.attribute.SourceIDAttribute;
import java.net.SocketImpl;
import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Ashesi Health Kiosk!!");

        System.out.println("Enter service code(P/L/T/C): ");
        String service_code = input.nextLine().toLowerCase();
        switch(service_code){
            case("p"):System.out.println("Go to the Pharmacy");break;
            case("l"):System.out.println("Go to the Lab desk");break;
            case("t"):System.out.println("Go to the Triage Desk");break;
            case("c"):System.out.println("Go to the Counseling Desk");break;
            default: System.out.println("Invalid service code");
       }
       int final_val = 0;
        if ("t".equals(service_code)){
            System.out.println("Enter your health metric: \n1. BMI \n2. Dosage round-up \n3. Simple trig helper");
            char health_metric = input.next().charAt(0);
            if (health_metric=='1'){
                System.out.println("Enter your weight(in kg) and your height(in meters)");
                double weight = input.nextDouble();
                double height = input.nextDouble();
                double bmi = weight / (height*height);
                double rounded_bmi = Math.round(bmi * 10)/10.0;
                final_val = (int)(rounded_bmi);
                System.out.println("BMI: "+ rounded_bmi);
                if (rounded_bmi < 18.5){
                    System.out.println("Underweight");
                }
                else if (rounded_bmi >= 18.5 && rounded_bmi <= 24.9){
                    System.out.println("Normal");
                }
                else if (rounded_bmi >=25.0 && rounded_bmi <=29.9){
                    System.out.println("Overweight");
                }
                else{
                    System.out.println("Obese");
                }
            }
            if (health_metric == '2'){
            System.out.println("Enter the required dosage(in mg):\nPharmacy limit is 250mg. ");
            final int tablets_limit = 250;
            double dosage = input.nextDouble();
            double number_of_tablets = Math.ceil(dosage/tablets_limit);
            double new_number_of_tablets = (int)(number_of_tablets);
            System.out.println("Number of tablets is:"+ new_number_of_tablets);
            final_val = (int)(new_number_of_tablets);
            }
            if (health_metric == '3'){
                System.out.println("Enter an angle(in degrees): ");
                double angle = input.nextDouble();
                double angle_radians = Math.toRadians(angle);
                System.out.println("The angle in radians is: "+ Math.round(angle_radians*1000)/1000.0);
                double angle_sin = Math.sin(angle_radians);
                double angle_cos = Math.cos(angle_radians);
                System.out.println("The sin of the angle is: "+ Math.round(angle_sin*1000)/1000.0);
                System.out.println("The cos of the angle is: "+ Math.round(angle_cos*1000)/1000.0);
                final_val = (int)(angle_radians);
            }

        }
        double random_num =(int)(65+(Math.random()*30));
        char random_char = (char)(random_num);
        int random_num1 = (int)(3 + (Math.random()*7));
        int random_num2 = (int)(3 + (Math.random()*7));
        int random_num3 = (int)(3 + (Math.random()*7));
        int random_num4 = (int)(3 + (Math.random()*7));
        String Student_ID = random_char+""+random_num1+random_num2+random_num3+random_num4;
        System.out.println("Student_ID: "+Student_ID);

        if (Student_ID.length()==5){
            if (Character.isLetter(Student_ID.charAt(0))){
                if (Character.isDigit(Student_ID.charAt(1)) && Character.isDigit(Student_ID.charAt(2)) && Character.isDigit(Student_ID.charAt(3)) && Character.isDigit(Student_ID.charAt(4)) ){
                    System.out.println("ID OK");
                }
            else {
                System.out.println("Invalid ID");
            }
        }

        System.out.println("Enter your name: ");
        String name=input.next().toUpperCase();
        char base_code = (name.charAt(0));
        char shifted_letter = (char)('A'+ (base_code - 'A' + 2) % 26);
        String last_two_chars = Student_ID.substring(3,5);
        String final_code = shifted_letter + last_two_chars + "-" + final_val;
        System.out.println("Final code is: "+ final_code);


        System.out.println("........Service Summary........");
        if ("p".equals(service_code)){
            System.out.println("PHARMACY"+"|"+ "ID= "+Student_ID+"|"+"Code= "+final_code);
        }
        else if ("t".equals(service_code)){
            System.out.println("TRIAGE"+"|"+ "ID= "+Student_ID+"|"+"Final Value= "+ final_val +"|"+ "Code= "+final_code);
        }
        else if ("l".equals(service_code)){
            System.out.println("LAB"+"|"+ "ID= "+Student_ID+"|"+"Code= "+final_code);

        }
        else if ("c".equals(service_code)){
            System.out.println("COUNSELING"+"|"+ "ID= "+Student_ID+"|"+"Code= "+final_code);

        }





    }

    
    
    }
}
