package jacksonlibrary;


import com.fasterxml.jackson.annotation.JsonProperty;

public class JSONWithPropertyNotValidData {
    // first name
    @JsonProperty("first name")
    private String firstName;
    @JsonProperty("last name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
