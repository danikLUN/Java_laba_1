class Customers {
    private String name;
    private int idNum;

    public Customers(String name, int idNum){
        this.name = name;
        this.idNum = idNum;
    }

    public String getName(){
        return this.name;
    }

    public int getIdNum(){
        return this.idNum;
    }

    public int CompareCustomer(Customers other){
        int nameComparison = this.getName().compareTo(other.getName()); //сравниваем по имени
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.getIdNum(), other.getIdNum()); //есди имена один. то сравниваем по id
    }

    public static void prefixMerge(Customers [] list1, Customers [] list2, Customers [] result){
        int i = 0, j = 0, k = 0;
        while (k < result.length) {
            if (i >= list1.length){
                result[k++] = list2[j++];
            }
            else if (j>= list2.length) {
                result[k++] = list1[i++];
            }
            else { // если еще ни один из листов не кончился
                int cp = list1[i].CompareCustomer(list2[j]); //сравниваем выяснив какое меньше
                if (cp < 0){
                    result[k++] = list1[i++];
                }
                else if (cp > 0) {
                    result[k++] = list2[j++];
                }
                else {
                    result[k++] = list2[j++];
                    i++;
                }
            }
        }
    }
};

class Funk {
    public void func_a() {
        Customers cur1 = new Customers("Smith", 1001);
        Customers cur2 = new Customers("Anderson", 1002);
        Customers cur3 = new Customers("Smith", 1003);

        System.out.println(cur1.CompareCustomer(cur1));
        System.out.println(cur1.CompareCustomer(cur2));
        System.out.println(cur1.CompareCustomer(cur3));
    }

    public void func_b() {
        Customers[] list1 = {
                new Customers("Arthur", 4920),
                new Customers("Burton", 3911),
                new Customers("Burton", 4944),
                new Customers("Franz", 1692),
                new Customers("Horton", 9221),
                new Customers("Jones", 5554),
                new Customers("Miller", 9360),
                new Customers("Nguyen", 4339)
        };

        Customers[] list2 = {
                new Customers("Aaron", 1729),
                new Customers("Baker", 2921),
                new Customers("Burton", 3911),
                new Customers("Dillard", 6552),
                new Customers("Jones", 5554),
                new Customers("Miller", 9360),
                new Customers("Noble", 3335)
        };

        int leng = Math.min(list1.length, list2.length);
        Customers [] result = new Customers[leng];

        Customers.prefixMerge(list1, list2, result);
        for(Customers c : result){
            System.out.println(c.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Funk f1 = new Funk();
        f1.func_a();
        f1.func_b();
    }
}
