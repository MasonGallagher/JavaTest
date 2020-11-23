import java.util.*;

/**
 * @author Mason on 23/11/2020 at 18:26
 */
public class Task1 {

    public static void main(String args[]) {

        String text ="this is a dog and this is a cat";
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));

        //Using TreeMap as it automatically sorts it's keys
        Map<String,Integer> map = new TreeMap<>();

        for(String word : words){
            if(map.containsKey(word)){
                map.put(word.toLowerCase(),map.get(word.toLowerCase())+1);
            }else{
                map.put(word.toLowerCase(),1);
            }
        }

        String alphabetical_order = map.entrySet().toString();
        System.out.println(alphabetical_order);

        // use regex to remove [ ] ,
        // these are all characters that will be added when I convert back to a list
        String regex = alphabetical_order.replaceAll("[\\[\\],]","");
        ArrayList<String> reverse_order = new ArrayList<>(Arrays.asList(regex.split(" ")));
        Collections.reverse(reverse_order);
        System.out.println(reverse_order);
    }
}
