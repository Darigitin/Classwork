public class Apr19
{
    public static void print2Dar(int ar2D[][])
    {
        for (int i=0; i<ar2D.length; i++)
        {
            for (int j=0; j<ar2D[i].length; j++)
            {
                System.out.print(ar2D[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int ar[];

        ar = new int[10];

        int ar2[] = new int[10];


        int ar2D[][] = new int[3][4];  // 3 rows & 4 cols

        ar2D[0][0] = 5;

        ar2D[2][3] = 23;

        //ar2D[3][2] = 32;   // row index is out of bounds!

        System.out.println("ar2D[1][1] = " + ar2D[1][1]);

        for (int i=0; i<ar2D.length; i++)
        {
            for (int j=0; j<ar2D[i].length; j++)
            {
                ar2D[i][j] = -1;
            }
        }

        int c=1;
        for (int i=0; i<ar2D.length; i++)
        {
            for (int j=0; j<ar2D[i].length; j++)
            {
                ar2D[i][j] = c;   // i = row, j = col
                c++;
            }
        }

       /* int anotherar2D[][] = new int[3][4];
        c=1;
        for (int i=0; i<ar2D.length; i++)
        {
            for (int j=0; j<ar2D[j].length; j++)
            {
                ar2D[j][i] = c;   // i = row, j = col
                c++;
            }
        }

        print2Dar(anotherar2D);*/
    }
}
