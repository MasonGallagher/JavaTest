import java.util.ArrayList;

/**
 * @author Mason on 23/11/2020 at 19:01
 */
public class Task2 {

    static class Product{
        int value;
        Product a;
        Product b;
        String operator;

        Product(int value){
            this.value = value;
        }

        Product(Product a, String operator, Product b){
            this.a = a;
            this.operator = operator;
            this.b = b;
        }


        int calculate(){
            if (operator != null){

                int val1 = a.calculate();
                int val2 = b.calculate();

                switch(operator){
                    case "+":
                        return val1 + val2;
                    case "-":
                        return val1 - val2;
                    case "*":
                        return val1 * val2;
                    default:
                        return value;
                }
            }
            return value;
        }

        @Override
        public String toString() {
            if (operator != null) {
                return "(" + a.toString() + operator + b.toString() + ")";
            }
            return value+"";
        }
    }

    private final static String[] operators = {"+","-","*"};

    public static void main(String args[]) {

        //define values
        int targetValue = 16;
        int[] numberList = {1,3,4,5};
        boolean solution = false;

        //initialise product list
        ArrayList<Product> products = new ArrayList<>();
        for(int num : numberList){
            products.add(new Product(num));
        }
        //get all possible permutations
        ArrayList<Product> permutations = get_permutations(products);
        for(Product p : permutations){
            //check if the sum of any of the permutations are equal to the target
            if(p.calculate() == targetValue){
                solution=true;
                System.out.println(p);
            }
        }
        if(!solution){
            System.out.println("No Solution found!");
        }
    }

    private static ArrayList<Product> get_permutations(ArrayList<Product> products) {

        //make copy of the list
        ArrayList<Product> productList = new ArrayList<>(products);

        for(Product product : products){
            ArrayList<Product> numbersCopy = new ArrayList<>(products);
            //remove the current product from copy list
            numbersCopy.remove(product);
            //recursively call until empty
            ArrayList<Product> newProducts = get_permutations(numbersCopy);

            for(Product newProd : newProducts){
                //perform all possible operations and add the products into the list
                for(String operator : operators){
                    Product p = new Product(product, operator, newProd);
                    productList.add(p);
                }
            }

        }
        return productList;
    }

}
