/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.utils.ArraysUtils;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.HashMap;

import cn.hutool.core.util.RandomUtil;

class Main2Test extends BaseTest<Main2> {

    public Main2Test() {
        super("com.huawei.codestudy.d20220304", Main2.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        int mapSideLen = 9;
        int gridSideLen = 3;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 3, 2);
        int[][] userArray = new int[][] {
            {3, 5},
            {7, 4},
            {6, 5},
            {5, 7},
            {2, 5},
            {5, 7}
        };
        int[] expect = new int[] {5, 2, 6, 8};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        int mapSideLen = 3;
        int gridSideLen = 1;
        Main2.Earthquake earthquake = new Main2.Earthquake(3, 0, 0);
        int[][] userArray = new int[][] {
            {2, 2},
        };
        int[] expect = new int[] {};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo01() {
        int mapSideLen = 3;
        int gridSideLen = 1;
        Main2.Earthquake earthquake = new Main2.Earthquake(3, 0, 0);
        int[][] userArray = new int[][] {
            {2, 2},
            {1, 2}
        };
        int[] expect = new int[] {6};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo02() {
        int mapSideLen = 3;
        int gridSideLen = 1;
        Main2.Earthquake earthquake = new Main2.Earthquake(3, 0, 0);
        int[][] userArray = new int[][] {
            {2, 2},
            {1, 2},
            {0, 0}
        };
        int[] expect = new int[] {1, 6};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo03() {
        int mapSideLen = 10;
        int gridSideLen = 5;
        Main2.Earthquake earthquake = new Main2.Earthquake(1, 3, 2);
        int[][] userArray = new int[][] {
            {3, 5},
            {7, 4},
            {6, 5},
            {5, 7},
            {2, 5},
            {5, 7},
        };
        int[] expect = new int[] {};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo04() {
        int mapSideLen = 10;
        int gridSideLen = 5;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 3, 2);
        int[][] userArray = new int[][] {
            {3, 5},
            {7, 4},
            {6, 5},
            {5, 7},
            {2, 5},
            {5, 7},
        };
        int[] expect = new int[] {3, 2};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo05() {
        int mapSideLen = 1;
        int gridSideLen = 1;
        Main2.Earthquake earthquake = new Main2.Earthquake(1, 0, 0);
        int[][] userArray = new int[][] {
            {0, 0},
        };
        int[] expect = new int[] {1};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo06() {
        int mapSideLen = 12;
        int gridSideLen = 3;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 2, 4);
        int[][] userArray = new int[][] {
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
        };
        int[] expect = new int[] {1};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo07() {
        int mapSideLen = 12;
        int gridSideLen = 3;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 2, 4);
        int[][] userArray = new int[][] {
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {10, 10},
            {10, 10},
            {10, 10},
        };
        int[] expect = new int[] {1};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo08() {
        int mapSideLen = 12;
        int gridSideLen = 3;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 2, 4);
        int[][] userArray = new int[][] {
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
            {10, 10},
            {10, 10},
            {10, 10},
            {1, 4},
            {1, 4},
            {1, 4},
        };
        int[] expect = new int[] {2, 1};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo09() {
        int mapSideLen = 12;
        int gridSideLen = 3;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 2, 4);
        int[][] userArray = new int[][] {
            {0, 0},
            {0, 0},
            {10, 10},
            {10, 10},
            {10, 10},
            {1, 4},
            {2, 8},
            {2, 8},
        };
        int[] expect = new int[] {2, 1, 3};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo10() {
        int mapSideLen = 12;
        int gridSideLen = 3;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 2, 4);
        int[][] userArray = new int[][] {
            {3, 0},
            {4, 0},
            {5, 1},
            {3, 6},
            {4, 7},
            {5, 8},
            {9, 3},
            {8, 3},
        };
        int[] expect = new int[] {5, 7, 10};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo11() {
        int mapSideLen = 12;
        int gridSideLen = 1;
        Main2.Earthquake earthquake = new Main2.Earthquake(6, 2, 4);
        int[][] userArray = new int[][] {
            {3, 0},
            {4, 0},
            {5, 1},
            {3, 6},
            {4, 7},
            {5, 8},
            {9, 3},
            {8, 3},
        };
        int[] expect = new int[] {43, 37, 56, 49, 62};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo12() {
        int mapSideLen = 1;
        int gridSideLen = 1;
        Main2.Earthquake earthquake = new Main2.Earthquake(1, 0, 0);
        int[][] userArray = new int[][] {
        };
        int[] expect = new int[] {};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo13() {
        int mapSideLen = 2;
        int gridSideLen = 1;
        Main2.Earthquake earthquake = new Main2.Earthquake(2, 0, 0);
        int[][] userArray = new int[][] {
            {0, 0},
            {1, 1}
        };
        int[] expect = new int[] {1, 4};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo14() {
        int mapSideLen = 18;
        int gridSideLen = 9;
        Main2.Earthquake earthquake = new Main2.Earthquake(2, 0, 0);
        int[][] userArray = new int[][] {
        };
        int[] expect = new int[] {};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo15() {
        int mapSideLen = 21;
        int gridSideLen = 7;
        Main2.Earthquake earthquake = new Main2.Earthquake(2, 0, 0);
        int[][] userArray = new int[][] {
            {0, 0}
        };
        int[] expect = new int[] {};
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void demo16() {
        int mapSideLen = 3909;
        int gridSideLen = 1303;
        Main2.Earthquake earthquake = new Main2.Earthquake(3511, 2190, 3284);
        int[][] userArray = new int[][] {
            {250, 234}, {1926, 828}, {2070, 1213}, {2392, 690}, {3030, 2301}, {3131, 1154}, {1402, 226}, {553, 753},
            {1081, 429}, {793, 2390}, {1090, 2242}, {3896, 1987}, {2264, 2019}, {1627, 3842}, {1353, 921}, {2847, 3074},
            {1803, 3373}, {980, 2270}, {785, 1160}, {3206, 2156}, {1723, 2432}, {1560, 3655}, {1397, 1322},
            {3615, 3566}, {3014, 349}, {2496, 975}, {3204, 3199}, {1916, 3275}, {87, 3396}, {335, 2657}, {1718, 299},
            {2589, 3093}, {956, 3363}, {3702, 640}, {274, 1631}, {2724, 307}, {2819, 3657}, {2429, 1833}, {2314, 145},
            {1908, 735}, {3448, 1806}, {1945, 2790}, {3215, 2509}, {28, 2956}, {1995, 395}, {2010, 248}, {3314, 2348},
            {1343, 3337}, {2015, 658}, {3489, 2912}, {668, 2236}, {2819, 2577}, {271, 980}, {3418, 3193}, {534, 3384},
            {2536, 445}, {3519, 144}, {3174, 647}, {354, 3679}, {44, 3659}, {1868, 2550}, {3243, 85}, {3667, 1916},
            {2979, 1261}, {2522, 1901}, {774, 1170}, {3011, 3104}, {1862, 606}, {3638, 1047}, {2405, 3555},
            {1820, 3798}, {2992, 2789}, {2938, 3706}, {2208, 1515}, {3645, 1227}, {129, 239}, {1898, 1795}, {737, 3736},
            {1036, 3613}, {1146, 2047}, {308, 1766}, {3901, 2809}, {2028, 2620}, {1741, 1750}, {2566, 521}, {485, 112},
            {256, 2441}, {2971, 3775}, {317, 895}, {1048, 1917}, {2252, 2777}, {3120, 744}, {2549, 576}, {3737, 3534},
            {3666, 3654}, {2858, 110}, {2307, 3078}, {489, 1799}, {3542, 835}, {333, 855}, {1717, 1393}, {1398, 1767},
            {3556, 1244}, {2380, 3577}, {2949, 2072}, {2667, 1121}, {786, 3553}, {2426, 2109}, {2898, 1652},
            {1561, 3293}, {1220, 901}, {3680, 3534}, {2175, 2648}, {3024, 122}, {3468, 2372}, {408, 61}, {2530, 3068},
            {1567, 3205}, {880, 1999}, {384, 230}, {1365, 933}, {1787, 3211}, {1545, 2178}, {2531, 919}, {1580, 1120},
            {2157, 1439}, {2378, 1903}, {3247, 3658}, {1794, 3243}, {2312, 384}, {499, 645}, {1368, 3233}, {2085, 623},
            {2181, 346}, {3297, 2323}, {2673, 936}, {1467, 406}, {3756, 3303}, {158, 2620}, {3066, 1542}, {2826, 2846},
            {3052, 2136}, {1867, 1761}, {487, 1800}, {1978, 2161}, {1404, 783}, {500, 1474}, {155, 3220}, {2035, 1559},
            {2080, 3219}, {1087, 2754}, {1376, 2754}, {2256, 3293}, {723, 3876}, {2356, 2372}, {3325, 3761},
            {1370, 583}, {3886, 2458}, {637, 2394}, {834, 356}, {3404, 1301}, {3314, 3162}, {2896, 3369}, {2424, 3354},
            {1536, 2289}, {1654, 1308}, {3186, 1684}, {945, 1536}, {635, 1873}, {1093, 1210}, {226, 534}, {524, 220},
            {391, 325}, {1690, 467}, {3403, 3053}, {3865, 890}, {1026, 1355}, {1202, 2571}, {2727, 419}, {2411, 1451},
            {1895, 1364}, {2415, 1746}, {1924, 660}, {1891, 3859}, {1285, 562}, {3719, 500}, {146, 2005}, {3880, 2734},
            {3902, 281}, {1066, 3073}, {3156, 110}, {2489, 2611}, {3252, 381}, {362, 2467}, {1369, 3495}, {1181, 2330},
            {3458, 2418}, {3283, 1908}, {231, 3289}, {335, 9}, {3765, 2917}, {3318, 3551}, {360, 2777}, {2585, 912},
            {2132, 1234}, {2973, 3457}, {3665, 1189}, {558, 3688}, {1868, 2352}, {2271, 1082}, {180, 557}, {1513, 2382},
            {3508, 927}, {2171, 3869}, {2739, 1252}, {2402, 3339}, {1898, 2176}, {1611, 108}, {431, 2125}, {59, 2980},
            {2874, 2913}, {898, 2713}, {1050, 3696}, {1214, 645}, {2673, 2603}, {2097, 1794}, {2541, 81}, {681, 352},
            {1396, 524}, {1876, 2694}, {2391, 3252}, {3364, 2566}, {2672, 177}, {2737, 3618}, {1931, 1720}, {827, 3020},
            {610, 1330}, {77, 1055}, {943, 1792}, {2700, 676}, {368, 3300}, {3642, 3354}, {3538, 2019}, {427, 1075},
            {34, 3018}, {1229, 3807}, {775, 3871}, {2918, 1773}, {3854, 390}, {1794, 3393}, {2365, 3662}, {3744, 2130},
            {3091, 1714}, {2934, 1294}, {1083, 3325}, {406, 1584}, {3718, 407}, {906, 2775}, {3277, 1661}, {2184, 274},
            {3221, 969}, {3581, 2523}, {2099, 2272}, {3194, 3363}, {376, 1677}, {2601, 872}, {3396, 3831}, {1136, 2582},
            {1281, 159}, {1645, 3375}, {2744, 1715}, {2256, 2295}, {2071, 2672}, {1226, 2648}, {2431, 2040},
            {1272, 2863}, {1894, 1218}, {3473, 3462}, {2734, 120}, {3502, 1912}, {454, 3078}, {3393, 1885}, {442, 2185},
            {585, 3101}, {1664, 3723}, {3006, 221}, {2883, 1044}, {1987, 2398}, {2038, 1007}, {310, 744}, {2081, 1914},
            {260, 573}, {2215, 1054}, {1040, 3069}, {3898, 1589}, {2405, 260}, {90, 2304}, {75, 3761}, {3727, 1553},
            {3352, 605}, {2628, 2914}, {259, 2111}, {3658, 1908}, {899, 2038}, {700, 4}, {767, 3573}, {168, 584},
            {2385, 1830}, {801, 2464}, {2917, 1476}, {802, 1057}, {101, 982}, {3865, 1893}, {2451, 491}, {1002, 3582},
            {126, 1655}, {3370, 3337}, {1028, 1322}, {3483, 3142}, {3289, 1012}, {3336, 2886}, {276, 286}, {1744, 1535},
            {1396, 1871}, {8, 1462}, {515, 3739}, {3258, 2201}, {1152, 2766}, {667, 3815}, {1919, 2363}, {3134, 3793},
            {87, 116}, {1859, 712}, {507, 667}, {1514, 3785}, {1527, 748}, {2703, 3332}, {2392, 2602}, {447, 1861},
            {2585, 3541}, {1435, 3481}, {3269, 3087}, {1174, 489}, {69, 2845}, {512, 2257}, {3606, 2332}, {1168, 747},
            {3598, 2209}, {3664, 3570}, {3822, 3163}, {3401, 1717}, {1390, 870}, {1005, 2347}, {3144, 3238},
            {603, 3096}, {2310, 3312}, {2944, 2422}, {462, 754}, {2747, 1186}, {852, 2401}, {3284, 871}, {3218, 987},
            {2377, 1568}, {1128, 1820}, {2261, 1900}, {1487, 1946}, {2677, 3652}, {2516, 382}, {3632, 3240},
            {1428, 2301}, {173, 3602}, {1439, 1754}, {1168, 3839}, {2014, 2153}, {3072, 3183}, {1328, 2936},
            {1215, 452}, {2518, 1965}, {3172, 2004}, {3160, 1552}, {1418, 964}, {2404, 1240}, {2723, 2658},
            {2222, 2648}, {891, 220}, {631, 3547}, {1431, 2489}, {2564, 2780}, {1864, 2832}, {3626, 145}, {275, 968},
            {3206, 2121}, {3419, 2490}, {1129, 222}, {3219, 1606}, {105, 2239}, {2719, 3494}, {2629, 544}, {2242, 3131},
            {2431, 2614}, {1902, 702}, {3802, 1312}, {3165, 2714}, {283, 2010}, {104, 2907}, {1883, 3412}, {3510, 1156},
            {3185, 1593}, {3246, 3209}, {1373, 2523}, {848, 1484}, {795, 167}, {107, 620}, {638, 3793}, {1832, 952},
            {2468, 558}, {2851, 1644}, {2194, 2176}, {3010, 265}, {2519, 436}, {2751, 1052}, {3748, 2188}, {2050, 796},
            {3048, 2581}, {682, 589}, {3609, 2169}, {3798, 3764}, {512, 3055}, {776, 3370}
        };
        int[] expect = AC02.getNotificationOrder(mapSideLen, gridSideLen, earthquake, userArray);
        run(mapSideLen, gridSideLen, earthquake, userArray, expect);
    }

    @Test
    void random() {
        int gridSideLen = RandomUtil.randomInt(1, 8191);
        if (gridSideLen % 2 == 0) {
            gridSideLen++;
        }
        int mapSideLen = RandomUtil.randomInt(gridSideLen, 8192);
        if (mapSideLen % gridSideLen != 0) {
            mapSideLen = mapSideLen / gridSideLen * gridSideLen;
        }
        int radius = RandomUtil.randomInt(1, 16000);
        int rowIdx = RandomUtil.randomInt(0, mapSideLen);
        int colIdx = RandomUtil.randomInt(0, mapSideLen);
        Main2.Earthquake earthquake = new Main2.Earthquake(radius, rowIdx, colIdx);
        int userNum = RandomUtil.randomInt(1, 1000);
        int[][] userArray = new int[userNum][];
        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = new int[] {RandomUtil.randomInt(0, mapSideLen), RandomUtil.randomInt(0, mapSideLen)};
        }
        HashMap<Class<? extends Main2>, int[]> resultMap = new HashMap<>();
        int finalMapSideLen = mapSideLen;
        int finalGridSideLen = gridSideLen;
        this.runCore(aClass -> {
            try {
                Main2 t = aClass.newInstance();
                int[] result = t.getNotificationOrder(finalMapSideLen, finalGridSideLen, earthquake, userArray);
                resultMap.put(aClass, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        int[] acResult = AC02.getNotificationOrder(finalMapSideLen, finalGridSideLen, earthquake, userArray);
        resultMap.forEach((k, v) -> {
            try {
                assertArrayEquals(acResult, v);
            } catch (AssertionFailedError e) {
                e.printStackTrace();
                System.out.printf("测试用例：gridSideLen=%s，mapSideLen=%s，Earthquake=%s,%s,%s，userArray=%s\n",
                    finalGridSideLen, finalMapSideLen, radius, rowIdx, colIdx,
                    ArraysUtils.strArraysToString(userArray));
                classResultMap.put(k, e);
            }
        });
    }

    @Test
    void runRandom() {
        for (int i = 0; i < 1000; i++) {
            this.random();
        }
    }

    private void run(int mapSideLen, int gridSideLen, Main2.Earthquake earthquake, int[][] userArray, int[] expect) {
        int[] acResult = AC02.getNotificationOrder(mapSideLen, gridSideLen, earthquake, userArray);
        this.runCore(aClass -> {
            try {
                Main2 main = aClass.newInstance();
                int[] result = main.getNotificationOrder(mapSideLen, gridSideLen, earthquake, userArray);
                assertArrayEquals(expect, result);
                try {
                    assertArrayEquals(expect, acResult);
                } catch (AssertionFailedError assertionFailedError) {
                    System.err.printf(
                        "-----------------------\n\n   except=%s but acResult=%s   \n\n-----------------------\n",
                        Arrays.toString(expect),
                        Arrays.toString(acResult));
                }
                assertArrayEquals(acResult, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

}