import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserProfile {
    private String username;
    private String email;
    private Optional<String> phoneNumber;
    private Optional<String> address;

    // Constructor


    public UserProfile(String username, String email, Optional<String> phoneNumber, Optional<String> address) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Optional<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }


}


