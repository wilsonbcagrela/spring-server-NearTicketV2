package io.swagger.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

import org.hibernate.annotations.ManyToAny;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Admin
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Entity
public class Admin   {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("phone")
  private Integer phone = null;

  /**
   * Role of the admin
   */
  public enum RoleEnum {
    TECHNICIAN("technician"),
    
    CONSULTANT("consultant"),
    
    HELPDESK("helpdesk");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }
    public String getValue(){
      return value;
    }
    // @Override
    // public String toString() {
    //   return String.valueOf(value);
    // }

    // @JsonCreator
    // public static RoleEnum fromValue(String text) {
    //   for (RoleEnum b : RoleEnum.values()) {
    //     if (String.valueOf(b.value).equals(text)) {
    //       return b;
    //     }
    //   }
    //   return null;
    // }
  }

  @JsonProperty("role")
  private RoleEnum role = null;

  @JsonProperty("isAdmin")
  private Boolean isAdmin = false;

  @JsonProperty("isEmailConfirmed")
  private Boolean isEmailConfirmed = false;
  
  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "admin_has_project", 
    joinColumns = {
      @JoinColumn(name = "Admin_id")},
    inverseJoinColumns = {
      @JoinColumn (name = "Project_id")
    }
  )
  private Set<Project> projects = new HashSet<>();
  

  public Set<Project> getProjects(){
    return projects;
  }


  public Admin id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Admin userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  **/
  @ApiModelProperty(value = "")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Admin firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Admin lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Admin email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Admin password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Admin phone(Integer phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")


  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }

  public Admin role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the admin
   * @return role
  **/
  @ApiModelProperty(value = "Role of the admin")


  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public Admin isAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
    return this;
  }

  /**
   * Get isAdmin
   * @return isAdmin
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public Admin isEmailConfirmed(Boolean isEmailConfirmed) {
    this.isEmailConfirmed = isEmailConfirmed;
    return this;
  }

  /**
   * Get isEmailConfirmed
   * @return isEmailConfirmed
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsEmailConfirmed() {
    return isEmailConfirmed;
  }

  public void setIsEmailConfirmed(Boolean isEmailConfirmed) {
    this.isEmailConfirmed = isEmailConfirmed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Admin admin = (Admin) o;
    return Objects.equals(this.id, admin.id) &&
        Objects.equals(this.userName, admin.userName) &&
        Objects.equals(this.firstName, admin.firstName) &&
        Objects.equals(this.lastName, admin.lastName) &&
        Objects.equals(this.email, admin.email) &&
        Objects.equals(this.password, admin.password) &&
        Objects.equals(this.phone, admin.phone) &&
        Objects.equals(this.role, admin.role) &&
        Objects.equals(this.isAdmin, admin.isAdmin) &&
        Objects.equals(this.isEmailConfirmed, admin.isEmailConfirmed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, firstName, lastName, email, password, phone, role, isAdmin, isEmailConfirmed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Admin {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    isAdmin: ").append(toIndentedString(isAdmin)).append("\n");
    sb.append("    isEmailConfirmed: ").append(toIndentedString(isEmailConfirmed)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

