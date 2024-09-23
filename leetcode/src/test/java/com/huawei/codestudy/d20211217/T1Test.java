/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.utils.ArraysUtils;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
class T1Test extends BaseTest<T1> {

    public T1Test() {
        super("com.huawei.codestudy.d20211217", T1.class);
    }

    @Test
    void case01() {
        String[] strings = new String[] {
            "DiskSystem", "add", "add", "add", "add", "remove", "remove", "add", "defrag", "add", "remove"
        };
        int[][] ints = new int[][] {{14}, {1, 2}, {2, 4}, {3, 2}, {5, 1}, {1}, {3}, {6, 5}, {}, {7, 4}, {7}};
        Integer[] expect = new Integer[] {null, 1, 5, 7, 8, 7, 9, 9, 3, 13, 4};
        run(strings, ints, expect);
    }

    @Test
    void case02() {
        String[] strings = new String[] {
            "DiskSystem", "add", "remove", "defrag"
        };
        int[][] ints = new int[][] {{10}, {1, 3}, {1}, {}};
        Integer[] expect = new Integer[] {null, 2, 10, 0};
        run(strings, ints, expect);
    }

    @Test
    void test03() {
        String[] strings = new String[] {
            "DiskSystem", "add", "add", "add", "remove", "add"
        };
        int[][] ints = new int[][] {{10}, {1, 3}, {2, 4}, {3, 3}, {1}, {1, 3}};
        Integer[] expect = new Integer[] {null, 2, 6, 9, 3, 2};
        run(strings, ints, expect);
    }

    @Test
    void test04() {
        String[] strings = new String[] {
            "DiskSystem", "add", "add", "add", "remove", "defrag", "add"
        };
        int[][] ints = new int[][] {{10}, {1, 3}, {2, 4}, {3, 3}, {1}, {}, {1, 3}};
        Integer[] expect = new Integer[] {null, 2, 6, 9, 3, 2, 9};
        run(strings, ints, expect);
    }

    @Test
    void test05() {
        String[] strings = new String[] {
            "DiskSystem", "add", "add", "add", "add", "remove", "remove", "add"
        };
        int[][] ints = new int[][] {{11}, {1, 3}, {2, 4}, {3, 3}, {4, 1}, {1}, {3}, {1, 5}};
        Integer[] expect = new Integer[] {null, 2, 6, 9, 10, 3, 6, 8};
        run(strings, ints, expect);
    }

    @Test
    void test06() {
        String[] strings = new String[] {
            "DiskSystem", "defrag", "defrag", "add", "add", "defrag", "defrag", "defrag", "remove", "remove", "add",
            "remove", "add", "remove", "remove", "defrag", "remove", "remove", "add", "add", "remove", "add", "remove",
            "remove", "add", "add"
        };
        int[][] ints = new int[][] {
            {36}, {}, {}, {6, 23}, {5, 16}, {}, {}, {}, {11}, {11}, {1, 16}, {3}, {6, 2}, {8}, {5}, {}, {6}, {4},
            {2, 13}, {11, 1}, {10}, {7, 9}, {6}, {11}, {1, 6}, {7, 17}
        };
        Integer[] expect = new Integer[] {
            null, 0, 0, 22, -1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, 36, -1, 12, 13, -1, 22, -1, 14, 27, -1
        };
        run(strings, ints, expect);
    }

    @Test
    void test07() {
        String[] strings = new String[] {
            "DiskSystem", "remove", "add", "add", "remove", "remove", "defrag", "add", "remove", "add", "add", "defrag",
            "add"
        };
        int[][] ints = new int[][] {
            {12}, {2}, {5, 2}, {5, 2}, {3}, {1}, {}, {2, 2}, {3}, {1, 9}, {5, 2}, {}, {1, 7}
        };
        Integer[] expect = new Integer[] {null, -1, 1, -1, -1, -1, 1, 3, -1, -1, -1, 2, 10};
        run(strings, ints, expect);

    }

    @Test
    void testRandom() {
        int size = RandomUtil.randomInt(2, 40);
        String[] operations = new String[size];
        int[][] nums = new int[size][];
        List<String> methods = Arrays.asList("add", "remove", "defrag");
        operations[0] = "DiskSystem";
        nums[0] = new int[] {RandomUtil.randomInt(1, size * 2)};
        for (int i = 1; i < operations.length; i++) {
            String randomEle = RandomUtil.randomEle(methods);
            operations[i] = randomEle;
            switch (randomEle) {
                case "add":
                    nums[i] = new int[] {RandomUtil.randomInt(1, size / 2), RandomUtil.randomInt(1, size)};
                    break;
                case "remove":
                    nums[i] = new int[] {RandomUtil.randomInt(1, size / 2)};
                    break;
                case "defrag":
                    nums[i] = new int[] {};
                    break;
            }
        }
        HashMap<Class<? extends T1>, Integer[]> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                Integer[] result = runResult(aClass, operations.clone(), nums.clone());
                resultMap.put(aClass, result);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        resultMap.forEach((k, v) -> System.out.println(k.getName() + "执行结果=" + Arrays.toString(v)));
        Map.Entry<Class<? extends T1>, Integer[]> baseEntry = null;
        boolean isSame = true;
        for (Map.Entry<Class<? extends T1>, Integer[]> classEntry : resultMap.entrySet()) {
            if (baseEntry == null) {
                baseEntry = classEntry;
                continue;
            }
            if (!isSame(classEntry.getValue(), baseEntry.getValue())) {
                log.error("{}与{}对比不一致，请检测。\n测试用例operations={},nums={}", classEntry.getKey(), baseEntry.getKey(),
                    ArraysUtils.strArraysToString(operations), ArraysUtils.strArraysToString(nums));
                isSame = false;
            }
        }
        assertTrue(isSame);
    }

    private void run(String[] strings, int[][] ints, Integer[] expect) {
        this.runCore(aClass -> {
            try {
                Integer[] integers = runResult(aClass, strings.clone(), ints.clone());
                assertTrue(isSame(integers, expect));
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean isSame(Integer[] expect, Integer[] result) {
        if (expect.length != result.length) {
            return false;
        }
        for (int i = 0; i < expect.length; i++) {
            if (expect[i] == null) {
                if (result[i] != null) {
                    return false;
                }
            } else if (!expect[i].equals(result[i])) {
                return false;
            }
        }
        return true;
    }

    private Integer[] runResult(Class<? extends T1> aClass, String[] strings, int[][] ints)
        throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Integer[] result = new Integer[strings.length];
        T1 t = null;
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            switch (string) {
                case "DiskSystem":
                    Constructor<? extends T1> declaredConstructor = aClass.getDeclaredConstructor(int.class);
                    t = declaredConstructor.newInstance(ints[i][0]);
                    result[i] = null;
                    break;
                case "add":
                    assert t != null;
                    int add = t.add(ints[i][0], ints[i][1]);
                    result[i] = add;
                    break;
                case "remove":
                    assert t != null;
                    int remove = t.remove(ints[i][0]);
                    result[i] = remove;
                    break;
                case "defrag":
                    assert t != null;
                    int defrag = t.defrag();
                    result[i] = defrag;
                    break;
                default:
                    throw new RuntimeException("no operation");
            }
        }
        return result;
    }

}