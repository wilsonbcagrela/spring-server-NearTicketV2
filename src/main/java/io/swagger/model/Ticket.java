package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ticket
 */
// @Validated
// @javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-04T14:58:39.313Z")

@Entity
public class Ticket   {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("deadLine")
  private String deadLine = null;

  @JsonProperty("urgency")
  private Boolean urgency = null;

  /**
   * ticket gravity
   */
  public enum GravityEnum {
    MILD("mild"),
    
    MEDIUM("medium"),
    
    SERIOUS("serious");

    private String value;

    GravityEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GravityEnum fromValue(String text) {
      for (GravityEnum b : GravityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("gravity")
  private GravityEnum gravity = null;

  @JsonProperty("supervisor")
  private String supervisor = null;

  /**
   * ticket status
   */
  public enum StatusEnum {
    NOT_INITIATED("not initiated"),
    
    IN_PROGRESS("in progress"),
    
    CONCLUDED("concluded");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("isRequest")
  private Boolean isRequest = false;

  @JsonProperty("isIssue")
  private Boolean isIssue = false;

  public Ticket id(Integer id) {
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

  public Ticket name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "issue with a part of the code", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Ticket description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "explains in detail what the issue is", value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Ticket deadLine(String deadLine) {
    this.deadLine = deadLine;
    return this;
  }

  /**
   * Get deadLine
   * @return deadLine
  **/
  @ApiModelProperty(example = "deadline to fix the issue", value = "")


  public String getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(String deadLine) {
    this.deadLine = deadLine;
  }

  public Ticket urgency(Boolean urgency) {
    this.urgency = urgency;
    return this;
  }

  /**
   * Get urgency
   * @return urgency
  **/
  @ApiModelProperty(value = "")


  public Boolean isUrgency() {
    return urgency;
  }

  public void setUrgency(Boolean urgency) {
    this.urgency = urgency;
  }

  public Ticket gravity(GravityEnum gravity) {
    this.gravity = gravity;
    return this;
  }

  /**
   * ticket gravity
   * @return gravity
  **/
  @ApiModelProperty(value = "ticket gravity")


  public GravityEnum getGravity() {
    return gravity;
  }

  public void setGravity(GravityEnum gravity) {
    this.gravity = gravity;
  }

  public Ticket supervisor(String supervisor) {
    this.supervisor = supervisor;
    return this;
  }

  /**
   * Get supervisor
   * @return supervisor
  **/
  @ApiModelProperty(value = "")


  public String getSupervisor() {
    return supervisor;
  }

  public void setSupervisor(String supervisor) {
    this.supervisor = supervisor;
  }

  public Ticket status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * ticket status
   * @return status
  **/
  @ApiModelProperty(value = "ticket status")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Ticket isRequest(Boolean isRequest) {
    this.isRequest = isRequest;
    return this;
  }

  /**
   * Get isRequest
   * @return isRequest
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsRequest() {
    return isRequest;
  }

  public void setIsRequest(Boolean isRequest) {
    this.isRequest = isRequest;
  }

  public Ticket isIssue(Boolean isIssue) {
    this.isIssue = isIssue;
    return this;
  }

  /**
   * Get isIssue
   * @return isIssue
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsIssue() {
    return isIssue;
  }

  public void setIsIssue(Boolean isIssue) {
    this.isIssue = isIssue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return Objects.equals(this.id, ticket.id) &&
        Objects.equals(this.name, ticket.name) &&
        Objects.equals(this.description, ticket.description) &&
        Objects.equals(this.deadLine, ticket.deadLine) &&
        Objects.equals(this.urgency, ticket.urgency) &&
        Objects.equals(this.gravity, ticket.gravity) &&
        Objects.equals(this.supervisor, ticket.supervisor) &&
        Objects.equals(this.status, ticket.status) &&
        Objects.equals(this.isRequest, ticket.isRequest) &&
        Objects.equals(this.isIssue, ticket.isIssue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, deadLine, urgency, gravity, supervisor, status, isRequest, isIssue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    deadLine: ").append(toIndentedString(deadLine)).append("\n");
    sb.append("    urgency: ").append(toIndentedString(urgency)).append("\n");
    sb.append("    gravity: ").append(toIndentedString(gravity)).append("\n");
    sb.append("    supervisor: ").append(toIndentedString(supervisor)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    isRequest: ").append(toIndentedString(isRequest)).append("\n");
    sb.append("    isIssue: ").append(toIndentedString(isIssue)).append("\n");
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

