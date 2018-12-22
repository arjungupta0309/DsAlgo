import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by arjun on 08/09/18.
 */
//a man has to break the rocks into tiny rocks. he is given rocks like mentioned below.
public class Q3 {

public static int Cal(List<Integer> list) {
    if (list == null || list.size() == 0) return 0;
    if (list.size() == 1) return list.get(0);
    int count = list.size();
    int size = list.size();
    int result = 0;

    while (count > 0) {
        Collections.sort(list);
        count--;
        int sub = list.get(size - 1) - list.get(size - 2);
        list.remove(size - 1);
        list.remove(size - 2);
        list.add(size - 2, 0);
        list.add(size - 1, sub);

        if (sub == 0) count--;
        if (count == 1) {
            result = sub;
            break;
        }
    }

    return result;
}

public static void main(String[] a){

    List<Integer> l = new ArrayList<>();

    l.add(46188086);
    l.add(339992587);
    l.add(742976890);
    l.add(801915058);
    l.add(393898202);
    l.add(717833291);
    l.add(843435009);
    l.add(361066046);
    l.add(884145908);
    l.add(668431192);
    l.add(586679703);
    l.add(792103686);
    l.add(85425451);
    l.add(246993674);
    l.add(134274127);
    l.add(586374055);
    l.add(923288873);
    l.add(292845117);
    l.add(399188845);
    l.add(842456591);
    l.add(410257930);
    l.add(333998862);
    l.add(16561419);
    l.add(624279391);
    l.add(459765367);
    l.add(969764608);
    l.add(508221973);
    l.add(82956997);
    l.add(437034793);
    l.add(553121267);
    l.add(554066040);
    l.add(199416087);

    int r = Cal(l);
    System.out.println(r);
}
}
