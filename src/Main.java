/**
 * Created by vadim on 26.11.16.
 */
class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Node node = null;
        String expr = "(132 + 72 / x + y - 65) ^ (23-x+6*(17/y)) ^ 1".replaceAll(" ", "");
        System.out.println(expr);
        try {
            node = parser.getNode(expr);
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        if (node != null) {
            System.out.println(node.toString());
            System.out.println(node.evaluate(9, 17));
        }

    }

}
