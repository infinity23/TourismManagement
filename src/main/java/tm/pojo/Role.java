package tm.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Role implements Serializable{
    private int id;
    private String role;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
