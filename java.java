#komentarz
#1
#2
public class SwapNumbers {

    public static void main(String[] args) {

        float first = 1.20f, second = 2.45f;

        System.out.println("--Before the swap--");
        System.out.println("First number is " + first);
        System.out.println("Second number = " + second);

        // Value of first is assigned to temporary
        float temporary = first;

        // Value of second is assigned to first
        first = second+20;

        System.out.println("changing numbrs");
        // Value of temporary (which contains the initial value of first) is assigned to second
        second = temporary;

        System.out.println("--After the swap--");
        System.out.println("First number+20 = " + first);
        System.out.println("Second number = " + second);
    }}
