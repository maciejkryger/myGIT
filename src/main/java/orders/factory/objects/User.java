package orders.factory.objects;

public class User {

    private String userName;
    private int userAge;

    public User(UserBuilder userBuilder) {
        this.userName=userBuilder.name;
        this.userAge=userBuilder.age;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    @Override
    public String toString() {
        return userName;
    }

    public static class UserBuilder{

        private String name;
        private int age;

        public UserBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
