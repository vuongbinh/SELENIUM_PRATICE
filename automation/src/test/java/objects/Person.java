package objects;

public class Person {
    private String lastName;
    private String firstName;
    private String email;
    private float dueMoney;
    private String webSite;

    public Person(String firstName, String lastName, String email, float dueMoney, String webSite) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dueMoney = dueMoney;
        this.webSite = webSite;
    }

    public Person() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public float getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(float dueMoney) {
        this.dueMoney = dueMoney;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }


    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
