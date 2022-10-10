import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isTheSame = true;
        String unavailable = null;
        
        Scanner myObj  = new Scanner(System.in);

        String[][] products = {{"candy" , "20"}, {"cookies" , "30"} , {"coca-cola" , "40"} , {"mangoes" , "50"} , {"chips" , "30"} , {"ice-cream" , "70"} , {"fanta" , "45"}  , {"sprite" , "50"} , {"milk" , "70"}} ;
        System.out.println("These are the products in our vending machine: ");
        System.out.println("======  ||    ||    ==========    ========");
        System.out.println("||      ||    ||  || ========= || ||    ||");
        System.out.println("||      ||    ||  || ========= || ||    ||");
        System.out.println("||      ||    ||  || ========= || ||    ||");
        System.out.println("======   ======   || ========= || ========");
        System.out.println("    ||  ||    ||  || ========= || ||");
        System.out.println("    ||  ||    ||  || ========= || ||");
        System.out.println("    ||  ||    ||  ||  ======== || ||");
        System.out.println("======  ||    ||    ==========    ||");
        for (int i =0; i < products.length; i++){
            for (int j=0; j < products[i].length ; j++){

                if(j== 0){
                    System.out.print(products[i][j] + " ==> ");
                }else{
                    System.out.print(products[i][j]);
                }
            }
            System.out.println("");
            System.out.println("");
        }
        System.out.println("Enter the your amount have: ");
        int amount = Integer.parseInt(myObj.nextLine());

        System.out.println("You have entered :  " + amount);

        System.out.println("");
        System.out.println("The following are the products you can afford with " + amount + "$");

        for (int i = 0; i < products.length; i++){
            for (int j =0; j < products[i].length; j++){
                int amounts = Integer.parseInt(products[i][1]);
                if (amounts <= amount){
                    if(j== 0){
                        System.out.print(products[i][j] + " ==> ");
                    }else{
                        System.out.print(products[i][j]);
                    }
                }else{
                    if(j== 0){
                        System.out.print(products[i][j] + " ==> ");
                    }else if(j == 1) {
                        System.out.print(products[i][j]);
                        System.out.print("$ ==> You can  not afford this");
                    }else{
                        System.out.print(products[i][j]);
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("");
        //the array of bouhgt items

        System.out.println("Enter the number of products you want to buy: ");
        int number = Integer.parseInt(myObj.nextLine());

        String bought[] = new String[number];

        for (int z =0; z < number ; z++){
            int position = z + 1;
            System.out.println("Product number " + position + " :  " );
            String object = myObj.nextLine();
            bought[z] = object;
        }

        System.out.println("");
        System.out.println("You want to buy: " );

        // displaying the products

        for (int y = 0; y < bought.length; y++){
            int numbering = y + 1;
            System.out.println( numbering + ". " +  bought[y]);
        }

        //buying the products
        int amountToPay = 0;

        for (int y = 0; y < bought.length; y++){
            for (int i=0; i < products.length; i++){
                String[] single = products[i];

                if(single[0].equals(bought[y]) && Integer.parseInt(single[1]) <= amount && amount > amountToPay ){

                     //   System.out.println("This is available : " + bought[y]);
                        amountToPay += Integer.parseInt(single[1]);
                        isTheSame = true;
                        break;
                }else{
                 //   System.out.println("This is not  available : " + bought[y]);
                    isTheSame = false;
                }
            }
           if(isTheSame == false){
                unavailable = bought[y];
                System.out.println("The Following product is not available: " + unavailable);
                System.exit(1);
            }
        }

        int balance = amount - amountToPay;
        System.out.println("You have entered $" + amount);


        //end choosing product

        if(amountToPay == 0 || balance < 0 || isTheSame == false){
            System.out.println(isTheSame);
            System.out.println("Some of the Products are unavailable or you are buying things that are more expensive than the money you entered !!! Try again");
        }else{

            // printing the buyed products

            System.out.println("You have bought the following products: ");

            for (int i =0; i < bought.length; i++){
                System.out.println(bought[i]);
            }

            System.out.println("You have used: $" + amountToPay);

            System.out.println("Your balance is: $" + balance);
            System.out.println("Thank you for using The Vending Machine");
        }

    }
}