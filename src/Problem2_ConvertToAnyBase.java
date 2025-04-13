public class Problem2_ConvertToAnyBase
{
    public static void main(String[] args)
    {
        int decimalNumber = 2024;
        int targetBase = 16;

        System.out.println("Decimal: " + decimalNumber);
        System.out.println("Converted to base " + targetBase + ": " + convertToAnyBase(decimalNumber, targetBase));
    }

    public static String convertToAnyBase(int num, int base)
    {
        if (num == 0)
        {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        
        while (num > 0)
        {
            int remainder = num % base;
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
            result.insert(0, digit);
            num /= base;
        }

        return result.toString();
    } 
}
