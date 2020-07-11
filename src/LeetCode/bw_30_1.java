package LeetCode;

public class bw_30_1 {
    static String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public String reformatDate(String date) {
        String trans = "";
        int index = 0;
        while (date.charAt(index) >= '0' && date.charAt(index) <= '9') {
            trans = trans+date.substring(index, index+1);
            index++;
        }
        if (index == 1)
            trans = "0"+trans;
        trans = "-"+trans;
        while (date.charAt(index) != ' ')
            index++;
        index++;
        for (int i = 1; i < 10; i++) {
            if (date.substring(index, index+3).equals(month[i-1]))
                trans = "-0"+i+trans;
        }
        for (int i = 10; i <= 12; i++) {
            if (date.substring(index, index+3).equals(month[i-1]))
                trans = "-"+i+trans;
        }
        trans = date.substring(date.length()-4)+trans;
        return trans;
    }
}
