public class LuckySevens {
    public static void main(String[] args)
    {
        System.out.println(luckySeven(1087171));
        System.out.println(luckySeven(1077171));
        System.out.println(luckySeven(77077));
        System.out.println(luckySeven(97171771707797L));
        System.out.println(luckySeven(1089651234));
    }

    public static int luckySeven(long number) {

        String s = String.valueOf(number);

        if(s.length() == 1)
        {
            return 0;
        }

        int r = 0;

        if(s.charAt(s.length() - 1) == '7')
        {
            r = 1;
        }
        if(s.length() > 1)
        {
            if(s.charAt(s.length()-2) == '7' && r == 1)
            {
                r = 2;
            }
        }

        if(r==2)
        {
            return 14 + luckySeven(number/100);
        }
        else
        {
            return r + luckySeven(number/10);
        }
        //System.out.println(a);
       /*  if(a < 10)
        {
            if(a == 7)
                return 1;
            return 0;
        }
        else if(a % 10 == 7)
        {
            if(luckySeven(a / 10) % 7 == 0)
            {
                return 7 + luckySeven(a / 100);
            }
            else
            {
                return 1 + luckySeven(a / 10);
            }
        }
        else
        {
            return luckySeven(a / 10);
        }
    } */
    }

}
