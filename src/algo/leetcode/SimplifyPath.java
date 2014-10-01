/**
 *
 */
package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cainwang
 *
 */
public class SimplifyPath {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String input = "/..";

        SimplifyPath solution = new SimplifyPath();
        String result = solution.simplifyPath(input);

        System.out.println(result);
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        Deque<String> paths = new LinkedList<>();
        String[] segs = path.split("/");

        for (int i = 0; i < segs.length; i ++) {
            String seg = segs[i];

            if (seg.length() == 0 || seg.equals(".")) {
                continue;
            }

            if (seg.equals("..")) {
                if (!paths.isEmpty()) {
                    paths.removeLast();
                }
            } else {
                paths.add(seg);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!paths.isEmpty()) {
            String pathElement = paths.remove();
            builder.append(pathElement);

            if (!paths.isEmpty()) {
                builder.append("/");
            }
        }

        if (path.startsWith("/")) {
            builder.insert(0, "/");
        }

        return builder.toString();
    }
}
