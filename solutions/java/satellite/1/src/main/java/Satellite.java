import java.util.List;

public class Satellite {
    public Tree treeFromTraversals(List<Character> preorderInput, List<Character> inorderInput) {
        if (preorderInput == null || inorderInput == null || preorderInput.size() != inorderInput.size()) {
            throw new IllegalArgumentException("traversals must have the same length");
        }

        if (!preorderInput.containsAll(inorderInput) || !inorderInput.containsAll(preorderInput)) {
            throw new IllegalArgumentException("traversals must have the same elements");
        }

        long uniqueCount = preorderInput.stream().distinct().count();
        if (uniqueCount != preorderInput.size()) {
            throw new IllegalArgumentException("traversals must contain unique items");
        }

        Node root = build(preorderInput, 0, preorderInput.size(), inorderInput, 0, inorderInput.size());
        return new Tree(root);
    }

    private Node build(List<Character> preorder, int preStart, int preEnd,
                       List<Character> inorder, int inStart, int inEnd) {
        if (preStart >= preEnd || inStart >= inEnd) {
            return null;
        }

        char rootVal = preorder.get(preStart);
        Node root = new Node(rootVal);

        int rootIndex = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder.get(i) == rootVal) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1) {
            throw new IllegalArgumentException("traversals must have the same elements");
        }

        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + 1 + leftSize,
                inorder, inStart, rootIndex);

        root.right = build(preorder, preStart + 1 + leftSize, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}
