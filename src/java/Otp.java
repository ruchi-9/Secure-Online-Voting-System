import java.util.*; 
public class Otp 
{ 
    public String OTP(int len) 
    {   
        String numbers = "0123456789"; 
        Random randomnumber = new Random(); 
        char[] otp = new char[len]; 
        for (int i = 0; i < len; i++) 
        { 
            otp[i] =  numbers.charAt(randomnumber.nextInt(numbers.length())); 
        } 
        System.out.println("otp is :"+otp.toString());
        return String.copyValueOf(otp); 
    } 
} 