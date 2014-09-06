/**
 *
 */
package algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class CloneGraph {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        UndirectedGraphNode result = cloneNode(node, map);

        return result;
    }

    private UndirectedGraphNode cloneNode(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode newNode = map.get(node);
        if (newNode != null) {
            return newNode;
        }

        newNode = new UndirectedGraphNode(node.label);
        List<UndirectedGraphNode> newNeighbors = new LinkedList<>();
        newNode.neighbors = newNeighbors;

        map.put(node,  newNode);

        List<UndirectedGraphNode> neighbors = node.neighbors;
        for (UndirectedGraphNode neighbor : neighbors) {
            newNeighbors.add(cloneNode(neighbor, map));
        }

        return newNode;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};