package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 Integer[] a = { 660, -5, 705, 405, 30, 184, 327, 77, 312, 943, 543, 934, 982, 735, 986, 714, 5, 800, 676, 769, 526, 0, 283, 452, 18, 837, 253, 915, 527, 973, 681, 118, 656, 38, 242, 683, 85, 947, 276, 247, 4, 524, 70, 926, 125, 368, 272, 506, 460, 354, 133, 350, 193, 147, 851, 415, 631, 206, 885, 929, 918, 684, 913, 966, 298, 478, 989, 605, 76, 310, 517, 688, 153, 919, 641, 737, 445, 321, 160, 898, 671, 925, 352, 555, 194, 665, 693, 868, 968, 186, 382, 61, 954, 503, 46, 531, 721, 701, 226, 748, 139, 523, 773, 131, 654, 571, 951, 835, 922, 911, 557, 497, 570, 251, 449, 765, 196, 668, 499, 292, 820, 618, 621, 399, 264, 534, 154, 75, 306, 512, 472, 157, 57, 113, 353, 104, 318, 999, 185, 37, 924, 720, 615, 447, 952, 446, 731, 401, 197, 761, 970, 515, 963, 575, 436, 41, 790, 457, 467, 430, 941, 901, 134, 156, 639, 468, 441, 93, 331, 287, 949, 228, 936, 187, 336, 149, 293, 381, 69, 824, 213, 431, 209, 645, 826, 792, 603, 116, 622, 950, 420, 179, 463, 629, 637, 427, 756, 79, 349, 26, 567, 702, 479, 14, 453, 317, 507, 862, 872, 23, 356, 675, 733, 841, 808, 300, 245, 15, 20, 745, 64, 319, 538, 22, 384, 241, 972, 168, 871, 290, 337, 205, -4, 351, 533, 278, 564, 712, 123, 838, 891, 476, 646, 204, 101, 827, 877, 129, 921, 42, 136, 874};
 ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));
 FirstMissingInteger fmi = new FirstMissingInteger();
 System.out.println(fmi.firstMissingPositive(arr));
 */
public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> a) {
        if(a.size() == 1 ) {
            if (a.get(0) == 1) return 2;
            if (a.get(0) != 1) return 1;
        }
        int expectedMiss = 0;
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) < 0) a.set(i, Integer.MIN_VALUE);
        }
        System.out.println(a);
        for (int i = 0; i < a.size(); i++) {
            int tmp = a.get(i);
            if(tmp == Integer.MIN_VALUE) continue;
            if (tmp < 0) tmp *= -1;
            if(tmp >= a.size()){
                continue;
            }else{
                if(a.get(tmp) == Integer.MIN_VALUE) {
                    a.set(tmp, Integer.MAX_VALUE);
                }else{
                    a.set(tmp, a.get(tmp)*-1);
                }
            }
        }
        System.out.println(a);
        while(++expectedMiss < a.size()){
            if ((a.get(expectedMiss) > 0 && a.get(expectedMiss) != Integer.MAX_VALUE) || a.get(expectedMiss) == Integer.MIN_VALUE) break;
        }
        if(expectedMiss == a.size()) expectedMiss++;
        return expectedMiss;

    }

}
