import java.util.*;

class Person {
    private String name;
    private int age;
    private String city;
    char Ram;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.Ram = 'R';
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return name + " (" + age + ") from " + city;
    }
}

class PersonManager {
    private List<Person> people;

    public PersonManager() {
        people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public void removePerson(String name) {
        people.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    public Person findPerson(String name) {
        for (Person p : people) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public List<Person> getPeopleFromCity(String city) {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (p.getCity().equalsIgnoreCase(city)) {
                result.add(p);
            }
        }
        return result;
    }

    public void printAll() {
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public int count() {
        return people.size();
    }
}

public class rahul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonManager manager = new PersonManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add person");
            System.out.println("2. Remove person");
            System.out.println("3. Find person");
            System.out.println("4. List people from city");
            System.out.println("5. Print all people");
            System.out.println("6. Count people");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter city: ");
                String city = sc.nextLine();
                manager.addPerson(new Person(name, age, city));
                System.out.println("Person added.");
            } else if (choice == 2) {
                System.out.print("Enter name to remove: ");
                String name = sc.nextLine();
                manager.removePerson(name);
                System.out.println("Person removed if existed.");
            } else if (choice == 3) {
                System.out.print("Enter name to find: ");
                String name = sc.nextLine();
                Person p = manager.findPerson(name);
                if (p != null) {
                    System.out.println("Found: " + p);
                } else {
                    System.out.println("Person not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter city: ");
                String city = sc.nextLine();
                List<Person> list = manager.getPeopleFromCity(city);
                if (list.isEmpty()) {
                    System.out.println("No people from " + city);
                } else {
                    for (Person p : list) {
                        System.out.println(p);
                    }
                }
            } else if (choice == 5) {
                manager.printAll();
            } else if (choice == 6) {
                System.out.println("Total people: " + manager.count());
            } else if (choice == 7) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}