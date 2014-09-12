/**
 *
 */
package algo;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class Sort123s {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = { 3, 2, 1, 3, 2, 1 };

        Sort123s solution = new Sort123s();
        solution.sort(array);

        System.out.println(Arrays.toString(array));
    }

    private void sort(int[] array) {
        int end1 = -1, end2 = -1, end3 = -1;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            switch (num) {
            case 1:
                if (end1 == -1) {
                    end1 = 0;
                }
                array[end1++] = 1;

                if (end2 != -1) {
                    array[end2++] = 2;
                }
                if (end3 != -1) {
                    array[end3++] = 3;
                }
                break;
            case 2:
                if (end2 == -1) {
                    if (end1 == -1) {
                        end2 = 0;
                    } else {
                        end2 = end1;
                    }
                }
                array[end2++] = 2;

                if (end3 != -1) {
                    array[end3++] = 3;
                }
                break;
            case 3:
                if (end3 == -1) {
                    if (end2 == -1) {
                        if (end1 == -1) {
                            end3 = 0;
                        } else {
                            end3 = end1;
                        }
                    } else {
                        end3 = end2;
                    }
                }
                array[end3++] = 3;

                break;
            }
        }
    }
}
