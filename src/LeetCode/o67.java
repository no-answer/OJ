package LeetCode;

public class o67 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int index = 0;
        while (str.charAt(index) == ' ') {
            index++;
            if (index == str.length())
                return 0;
        }
        boolean mark = true;
        if (str.charAt(index) == '+')
            index++;
        else if (str.charAt(index) == '-') {
            index++;
            mark = false;
        }
        if (index == str.length())
            return 0;
        if (!(str.charAt(index) >= '0' && str.charAt(index) <= '9'))
            return 0;
        long count = 0;
        while (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            if (mark) count = count*10+str.charAt(index)-'0';
            else count = count*10-str.charAt(index)+'0';
            if (mark && count > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (!mark && count < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            index++;
            if (index == str.length())
                break;
        }
        return (int)count;
    }
}
