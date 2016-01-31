import java.io.*;


public class Sept29
{
    public static void main(String args[] ) throws IOException
    {
        // declare our variables:
        BufferedReader input =
        new BufferedReader(new InputStreamReader(System.in ));

        int grade;
        String input_string;

        while(true)
        {
            System.out.println("enter a grade (-1 to quit): " );
            input_string = input.readLine();
            grade = Integer.parseInt(input_string);
            System.out.println("grade = " + grade);

            if (grade == -1) break;


            if (grade >= 90)
            {
                System.out.println(grade + " is an A!");
            }
            else if (grade >= 80)
            {
                System.out.println(grade + " is a B!");
            }
            else if (grade >= 70)
            {
                System.out.println(grade + " is a C!");
            }
            else if (grade >= 60)
            {
                System.out.println(grade + " is a D.");
            }
            else // if (grade >= 0)
            {
                System.out.println("see you next semester.");
            }
        }
    }
}


