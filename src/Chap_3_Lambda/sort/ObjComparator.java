package Chap_3_Lambda.sort;

import java.util.Comparator;

public class ObjComparator implements Comparator<Main.Obj> {

    @Override
    public int compare(Main.Obj o1, Main.Obj o2) {
        return o1.weight - o2.weight;
    }
}
