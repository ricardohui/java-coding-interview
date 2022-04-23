import com.sun.jmx.snmp.SnmpUnknownModelException;

class HappyNumber {

    public static boolean find(int num) {
     int fast = num;
     int slow = num;

     do {
            slow = sumOfTheSquare(slow);
            fast = sumOfTheSquare(sumOfTheSquare(fast));
     } while (fast != slow);

        return 1 == slow;
    }

    private static int sumOfTheSquare(int num) {
        int sum = 0;
        while (num>0){
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}