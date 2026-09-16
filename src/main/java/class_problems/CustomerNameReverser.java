package class_problems;

public class CustomerNameReverser {
    public String reverseCustomerName(String customerName) {
        if (customerName == null || customerName.isEmpty()) {
            return customerName;
        }

        char[] characters = customerName.toCharArray();
        String reversed = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            reversed += characters[i];
        }

        return reversed;
    }

    public static void main(String[] args) {
        CustomerNameReverser reverser = new CustomerNameReverser();

        String name = "Sunil";
        String reversedName = reverser.reverseCustomerName(name);

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversedName);

        String secondName = "Anitha";
        System.out.println("Original Name: " + secondName);
        System.out.println("Reversed Name: " + reverser.reverseCustomerName(secondName));
    }
}
