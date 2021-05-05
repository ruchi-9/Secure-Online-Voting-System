import java.util.*; 
public class Password {
public  String GenratePassword(int len) 
    { 
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 
        String values = Capital_chars + Small_chars + numbers; 
       
        Random randomNumber = new Random(); 
        char[] password = new char[len]; 
        for (int i=0;i<len;i++) 
        { 
        password[i] = values.charAt(randomNumber.nextInt(values.length())); 
        } 
        String b=new String(password);
        return b; 
    } 


}     
