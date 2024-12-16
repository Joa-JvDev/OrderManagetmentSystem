package jva.dev.ordermanagetmentsystem.dto;

public class CustomerDTO {

    private Long id;
    private String firstName;
    private String email;
    private String phone;

    public CustomerDTO(Long id, String firstName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
    }

    public CustomerDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}




