import java.time.LocalDate;
import java.time.LocalDateTime;

class User {
    String username;
    String password;
    String mobileNumber;
    boolean isActive;
    String gender;
    LocalDate createdDate;

    public User(String username, String password, String mobileNumber, boolean isActive, String gender,
            LocalDate createdDate) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.isActive = isActive;
        this.gender = gender;
        this.createdDate = createdDate;
    }

    public void printUser() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Active: " + isActive);
        System.out.println("Gender: " + gender);
        System.out.println("Created Date: " + createdDate);
    }
}

class StandardUser extends User {
    String alias;
    LocalDateTime lastLogin;
    String role;

    public StandardUser(String username, String password, String mobileNumber, boolean isActive, String gender,
            LocalDate createdDate,
            String alias, LocalDateTime lastLogin, String role) {
        super(username, password, mobileNumber, isActive, gender, createdDate);
        this.alias = alias;
        this.lastLogin = lastLogin;
        this.role = role;
    }

    @Override
    public void printUser() {
        super.printUser();
        System.out.println("Alias: " + alias);
        System.out.println("Last Login: " + lastLogin);
        System.out.println("Role: " + role);
    }
}

class CustomUser extends User {
    String email;
    String securityKey;
    String manager;

    public CustomUser(String username, String password, String mobileNumber, boolean isActive, String gender,
            LocalDate createdDate,
            String email, String securityKey, String manager) {
        super(username, password, mobileNumber, isActive, gender, createdDate);
        this.email = email;
        this.securityKey = securityKey;
        this.manager = manager;
    }

    @Override
    public void printUser() {
        super.printUser();
        System.out.println("Email: " + email);
        System.out.println("Security Key: " + securityKey);
        System.out.println("Manager: " + manager);
    }    
}

public class prac_4 {
    public static void main(String[] args) {
        boolean custom_nf=true,female_nf=true;
        // Create users
        User[] users = new User[4];
        users[0] = new StandardUser("user1", "password1", "1234567890", true, "Male", LocalDate.of(1999, 8, 14),
                "alias1", LocalDateTime.of(2023, 8, 6, 7, 14, 3), "role1");
        users[1] = new StandardUser("user2", "password2", "0987654321", true, "Male", LocalDate.of(2001, 5, 8),
                "alias2", LocalDateTime.of(2022, 8, 4, 7, 14, 16), "role2");
        users[2] = new CustomUser("user3", "password3", "1111111111", true, "Female", LocalDate.of(1993, 12, 8),
                "user3@gl.com", "key1", "manager1");
        users[3] = new CustomUser("user4", "password4", "2222222222", true, "Male", LocalDate.of(1999, 1, 15),
        "user4@yahoo.com", "key2", "manager2");
        // Display all female standard users
        System.out.println("Female Standard Users:");
        for (User user : users) {
            if (user instanceof StandardUser && user.gender.equals("Female")) {
                user.printUser();
                System.out.println("------------------------");
                female_nf=false;
            }
        }
        if(female_nf){
            System.out.println("+++NO RECORD FOUND +++");
        }
        // Display all custom users created before 1 Jan 2000 with email ID containing
        // "gmail.com"
        
        System.out.println("Custom Users created before 1 Jan 2000 with gmail.com email:");
        for (User user : users) {
            if (user instanceof CustomUser && ((CustomUser) user).email.contains("@gmail.com")
            && user.createdDate.isBefore(LocalDate.of(2000, 1, 1))) {
                user.printUser();
                System.out.println("-------------------------");
                custom_nf=false;
            }
        }
        
        if(custom_nf){
            System.out.println("+++NO RECORD FOUND +++");
        }
    }
}
