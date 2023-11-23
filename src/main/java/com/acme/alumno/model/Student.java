package com.acme.alumno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String career;
  private String email;
  private String phone;
  private String document;

  public Student() {

  }

  // Getters y setters
  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getCareer() {
      return career;
  }

  public void setCareer(String career) {
      this.career = career;
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

  public String getDocument() {
      return document;
  }

  public void setDocument(String document) {
      this.document = document;
  }

  @Override
  public String toString() {
      return "Student{" +
              "name='" + name + '\'' +
              ", career='" + career + '\'' +
              ", email='" + email + '\'' +
              ", phone='" + phone + '\'' +
              ", document='" + document + '\'' +
              '}';
  }

}
