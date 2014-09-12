/**
 *
 */
package algo;

/**
 * @author Cain
 *
 */
public class Trial {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";
        System.out.println(s1 == s2);

        StringBuilder builder = new StringBuilder();
        builder.append("te");
        builder.append("st");

        System.out.println(s1 == builder.toString().intern());
    }

}
