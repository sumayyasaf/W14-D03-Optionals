import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalMain {
    public static void main(String[] args) {
        UserProfile user1 = new UserProfile("CLair", "clair@example.com", Optional.of("123-456-7890"), Optional.empty());
        UserProfile user2 = new UserProfile("Bob", "bob@example.com", Optional.empty(), Optional.of("123 Street, City"));
        UserProfile user3 = new UserProfile("Rob", "rob@example.com", Optional.empty(), Optional.empty());

        // Task 1
        System.out.println("User Profile:");
        printUserProfile(user1);

        // Task 2
        System.out.println("Phone Number:");
        System.out.println(getPhoneNumber(user3));

        // Task 3
        List<UserProfile> users = Arrays.asList(user1, user2, user3);
        System.out.println("Users with Address:");
        List<UserProfile> usersWithAddress = filterUsersWithAddress(users);
        usersWithAddress.forEach(user -> System.out.println(user.getUsername()));

        // Task 4
        System.out.println("Updating Address:");
        updateAddress(user1, "456 Avenue, City");
        updateAddress(user3, "789 Boulevard, City");
    }

public static void printUserProfile(UserProfile user) {
    System.out.println("Username: " + user.getUsername());
    System.out.println("Email: " + user.getEmail());

    System.out.println("Phone Number: " + user.getPhoneNumber().orElse("Phone number is missing."));
    System.out.println("Address: " + user.getAddress().orElse("Address is missing."));
}

public static String getPhoneNumber(UserProfile user) {
    return user.getPhoneNumber().orElse("No phone number is available");
}

public static List<UserProfile> filterUsersWithAddress(List<UserProfile> users) {
    return users.stream()
            .filter(user -> user.getAddress().isPresent())
            .collect(Collectors.toList());
}

public static void updateAddress(UserProfile user, String newAddress) {
    if (user.getAddress().isEmpty()) {
        user.setAddress(Optional.of(newAddress));
        System.out.println("Address updated to: " + newAddress);
    } else {
        System.out.println("Address is already present and was not updated.");
    }

}
}
