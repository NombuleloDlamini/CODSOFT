import java.util.*;
import java.io.*;

//Input: Take marks obtained (out of 100) in each subject.
//        Calculate Total Marks: Sum up the marks obtained in all subjects.
//        Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
//        average percentage.
//        Grade Calculation: Assign grades based on the average percentage achieved.
//        Display Results: Show the total marks, average percentage, and the corresponding grade to the user


public class Task2 {
    public static void main(String[] args){
        int sum = 0;
        int mark = 0;
        int average = 0;
        String subject = null;
        String subArr[];


        // GETTING INPUT
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of subjects");

        System.out.println("Enter subjects with marks(separated by a '-') in a comma separated list:" +
                " (subject1-mark1,subject2-mark2,subject3-mark3...) ");
        String line = input.next();


        // WORKING WITH INPUT
        String subjects = line.replace(" ","");   // in case input has spaces
        String subjectList[] = subjects.split(",");

            for (int i = 0; i < subjectList.length; i++) {


                subArr = subjectList[i].split("-");
                subject = subArr[0];
                mark = Integer.parseInt(subArr[1]);
                sum += mark;                                           // TOTAL MARKS
                average = sum / subjectList.length ;                  // AVERAGE PERCENTAGE

                // GRADE CALCULATION
                if (mark > 74) {
                    System.out.println(subject + " A");
                } else if (mark > 69) {
                    System.out.println(subject + " B");
                } else if (mark >59) {
                    System.out.println(subject + " C");
                } else if (mark > 49) {
                    System.out.println(subject + " D");
                } else {
                    System.out.println(subject + " F");
                }
                
            }
        System.out.println("Total marks: "+ sum);
        System.out.println("Average percentage: "+ average + "%");

    }
}
