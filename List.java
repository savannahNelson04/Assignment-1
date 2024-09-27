public class List {

    private String[] errors;
    private int size;
    private int index;

    public List(int capacity) {
        errors = new String[capacity];
        size = 0;
        index = 0;
    }

    public void addError(String error) {
        errors[index] = error;
        index = (index + 1) % errors.length;
        if (size < errors.length) {
            size++;
        }
    }

    public void printErrors() {
        for (int i = 0; i < size; i++) {
            System.out.println(errors[(index + i) % errors.length]);
        }
    }


}
