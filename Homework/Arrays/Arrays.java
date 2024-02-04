public class Arrays{
    private int size; 
    private int capacity; 
    private int[] arr;

    public Arrays(int length) {
        size = 0;
        capacity = length;
        arr = new int[length];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean is_empty() {
        return this.size == 0;
    }

    public int at(int index) throws Exception {
        if (index < 0 || index > this.size - 1) {
            throw new Exception("Index out of bounds");
        }

        return this.arr[index];
    }

    public void push(int item) {
        this.resize(size);

        this.arr[size++] = item;
    }

    public void insert(int index, int item) throws Exception {
        if (index < 0 || index > size - 1) {
            throw new Exception("Index out of bounds");
        }

        this.resize(size);
        
        for (int i = size + 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = item;
        size++;
    }

    public void prepend(int item) throws Exception {
        this.insert(0, item);
    }

    public int pop() throws Exception {
        if (size <= 0) {
            throw new Exception("Index out of bounds");
        }
        int result = arr[size - 1];
        size--;
        this.resize(size);

        return result;
    }

    public void delete(int index) throws Exception {
        if (index < 0 || index > size - 1 || size <= 0) {
            throw new Exception("Index out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        this.resize(size);
    }

    public void remove(int item) throws Exception {
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) {
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
                i--;
            }
        }
    }

    public int find(int item) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == item) {
                return i;
            }
        }

        return -1;
    }

    private void resize(int current_size) {
        if (current_size < 16) {
            return;
        }

        if (current_size == capacity) {
            capacity *= 2;
            int[] newArr = new int[capacity];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            } 

            this.arr = newArr;
        } else if (current_size < capacity / 4) {
            this.capacity /= 2;
            int[] newArr = new int[this.capacity];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            this.arr = newArr;
        }
        return;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(String.valueOf(arr[i]) + ',');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Arrays test = new Arrays(16);

        test.push(2);
        test.push(5);
        test.push(5);
        test.push(5);
        test.push(7);

        System.out.println(test);
        
        test.pop();
        System.out.println(test);

        test.push(9);
        test.push(4);
        test.push(5);

        System.out.println(test);

        test.delete(1);
        System.out.println(test);

        test.remove(5);
        System.out.println(test);

        System.out.println("Find: " + test.find(10));

        test.prepend(10);
        System.out.println(test);
    }
}
