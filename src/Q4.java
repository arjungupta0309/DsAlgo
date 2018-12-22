/**
 * Created by arjun on 09/09/18.
 */
/*2
        3
        0001000*/
public class Q4 {

    static int m(int p, int q, String s){
        if (s == null || s.length()==0 || s.length()==1) return 0;
        int profit_p = 0, profit_q = 0;
        boolean p_start = false, q_start = false;
        int count = 0;

        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch=='0' && !p_start && !q_start){
                count++;
                p_start = q_start = true;
            }
            else if (ch=='0' && p_start && !q_start){
                count++;
                if (count==3){
                    profit_p += p;
                    p_start=false;
                    q_start=true;
                }
            }
            else if (ch=='0' && q_start){
                profit_q += q;
                q_start = false;
            }
            else if (ch=='1' && q_start){
                profit_q += q;
                q_start = false;
            }
            else if (ch=='1' && !q_start){
                q_start=true;
            }

        }

        return Math.max(profit_p, profit_q);
    }
}
