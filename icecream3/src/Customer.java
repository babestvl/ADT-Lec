public class Customer implements Comparable<Customer> {
    public int age;
    public int id;

    public Customer(int i, int a) {
        id = i; age = a;
    }

    @Override
    public int compareTo(Customer a) {
        if(age < a.age) {
            return -1;
        } else if(age > a.age) {
            return 1;
        } else {
            return 0;
        }
    }
}
