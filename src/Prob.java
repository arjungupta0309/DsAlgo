import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arjun on 29/04/19.
 */
public class Prob {

    static Map<String, Boolean> map = new HashMap();



    public boolean exist(int ind,String src,String curr){
        if(ind == (src.length()-1))
            return map.containsKey(curr+src.charAt(ind));
        boolean is_exist = exist(ind+1,src,curr+src.charAt(ind));
        if (is_exist)
            return true;
        if (map.containsKey(curr+src.charAt(ind)))
            return exist(ind+1,src,"");
        return false;
    }


    public static void main(String[] a){

        Prob o = new Prob();
        map.put("My", false);
        map.put("name", false);
        map.put("is", false);
        map.put("sam", false);
        map.put("Myname", false);
        map.put("i", false);
        System.out.println(o.exist(0, "Mynameissam", ""));


    }

}
