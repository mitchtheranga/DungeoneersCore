package dungeoneers;

import org.bukkit.ChatColor;

import java.util.Random;

public class Utils {
    public static String chat(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static Integer getRandomInt(Integer max) {
        Random ran = new Random();
        return ran.nextInt(max);
    }

    public static String invis(String message){
        String hidden = "";
        for(char c : message.toCharArray()){
            hidden += ChatColor.COLOR_CHAR + "" + c;
        }
        return hidden;
    }
}
