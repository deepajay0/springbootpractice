package com.springboot.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(
        description = "StudentDTO model Information"
)
public class StudentDTO {
    private Long id;
    @Schema(
            description = "User first name"
    )
    @NotEmpty(message = "First name should not be blank")
    private String firstName;
    @Schema(
            description = "User last name"
    )
    @NotEmpty(message = "last name should not be blank")
    private String lastName;
    @Schema(
            description = "User email address"
    )
    @NotEmpty(message ="Email should not be blank")
    @Email(message = "Email should be valid")
    private String email;
    private String branch;

    public StudentDTO(Long id, String firstName, String lastName, String email, String branch) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.branch = branch;
    }

    public StudentDTO() {
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
