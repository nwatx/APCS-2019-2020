public class Inheritance
{
  public static void main(String[] args) {
    String x = "aplus";
    String y = x;
    x = null;
    System.out.println("1. " + y);

    String a = "whoot";
    String b = a;
    b = null;
    System.out.println("2. " + a);

    B test = new B();
    String g = "25";
    String h = "16";
    int z = 5, w = 10;
    int[] list = new int[3];

    test.mystery1(g,h);
    System.out.println("3. " + g + " " + h);

    test.mystery2(z,w);
    System.out.println("4. " + z + " " + w);

    test.mystery3(list);
    for( int i = 0; i < list.length; i++)
       System.out.print(list[i] + " ");
    System.out.println();

    test.mystery4(list);
    for( int i = 0; i < list.length; i++)
       System.out.print(list[i] + " ");

      }
}

class B {
   public void mystery1(String one, String two){
      one = two;
      two = "aplus";
      System.out.println(one);
   }
   public void mystery2(int one, int two){
      one = two;
   }
   public void mystery3(int[] ray){
      ray = new int[4];
   }
   public void mystery4(int[] ray){
      ray[0] = 7;
      ray[1] = 4;
   }
}
