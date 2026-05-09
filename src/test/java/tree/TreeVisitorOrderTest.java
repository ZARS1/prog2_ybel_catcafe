package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TreeVisitorOrderTest {
    @Test
    void givenEmptyTree_whenInOrderVisitorVisitsTree_thenReturnsEmptyString() {
        Tree<Integer> tree = new Empty<>();

        String result = tree.accept(new InOrderVisitor<>());

        assertEquals("", result);
    }

    @Test
    void givenTree_whenInOrderVisitorVisitsTree_thenReturnsLeftDataRight() {
        Tree<Integer> tree = new Empty<>();
        tree = tree.addData(2);
        tree = tree.addData(1);
        tree = tree.addData(3);

        String result = tree.accept(new InOrderVisitor<>());

        assertEquals("123", result);
    }

    @Test
    void givenEmptyTree_whenPostOrderVisitorVisitsTree_thenReturnsEmptyString() {
        Tree<Integer> tree = new Empty<>();

        String result = tree.accept(new PostOrderVisitor<>());

        assertEquals("", result);
    }

    @Test
    void givenTree_whenPostOrderVisitorVisitsTree_thenReturnsLeftRightData() {
        Tree<Integer> tree = new Empty<>();
        tree = tree.addData(2);
        tree = tree.addData(1);
        tree = tree.addData(3);

        String result = tree.accept(new PostOrderVisitor<>());

        assertEquals("132", result);
    }
}
