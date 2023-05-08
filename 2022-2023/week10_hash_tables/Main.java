public class Main {
    public static void main(String[] args) {
        testMapImplementation(1); // list map
        testMapImplementation(2); // chaining
    }

    static void testMapImplementation(int i) {
        Map<String, String> map;
        if(i == 1) map = new ListMap<>();
        else if (i == 2) map = new ChainHashMap<>();
        else throw new RuntimeException("Wrong Input");
        map.put("id", "1234");
        map.put("name", "Foo");
        map.put("job", "nothing");
        for(Item<String, String> item : map.items())
            System.out.println("Key: " + item.getKey() + ", value: " + item.getValue());
        map.put("origin", "Mars");
        map.put("job", "nothing, just hanging around");
        System.out.println("Where are you from? ---> " + map.get("origin"));
        System.out.println("What do you do? ---> " + map.get("job"));
        map.remove("id");
        System.out.println("What is your id? ---> " + map.get("id"));
        System.out.println("Size: " + map.size());
        System.out.println("--".repeat(15));
    }
}
