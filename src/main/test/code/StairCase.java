package code;

import java.io.IOException;

public class StairCase
{
    public static void main(String[] args) throws IOException
    {
        int in = 10;

        int staircase = 0;
        String out = "";
        int pre = 0;



        for (int i = 1; i <= in; i++ )
        {
            if ((pre  + i)> in)
            {
                staircase = --i;
                System.out.println("break: " + staircase);
                break;
            }

            pre +=  i;
            //System.out.println("i: " + i + " pre: " + pre);

        }


    }

}

/*
	//code
		//System.out.println("IN: " + Arrays.toString(args));
	         Scanner sc = new Scanner(System.in);
            Scanner sc = new Scanner(System.in);
	    int inCount = Integer.parseInt(sc.nextLine());
        int inputs[]=new int[inCount];
        // get all inputs
        for (int i = 0; i < inCount ; i++) {
            inputs[i] = sc.nextInt();
        }
        for(int j = 0; j < inCount; j++){
             int in = inputs[j];

            //System.out.println("IN: " + in);
            int staircase = 0;
            String out = "";
            int pre = 0;

            if (in == 1)
            {
                System.out.println(in);
            } else
            {

                for (int k = 1; k <= in; k++)
                {
                    if ((pre + k) > in)
                    {
                        staircase = --k;
                        System.out.println( staircase);
                        break;
                    }

                    pre += k;


                }
            }
        }

 */
