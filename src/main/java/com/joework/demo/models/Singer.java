package com.joework.demo.models;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "singers")
public class Singer {

        private Long id;
        private String firstName;
        private String lastName;
        private Date birthDate;
        private int version;
        public void setId(Long id) {
            this.id = id;
        }

        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "ID")
        public Long getId() {
            return this.id;
        }
        @Version
        @Column(name = "VERSION")
        public int getVersion() {
            return version;
        }
        @Column(name = "FIRST_NAME")
        public String getFirstName() {
            return this.firstName;
        }
        @Column(name = "LAST_NAME")
        public String getLastName() {
            return this.lastName;
        }
        @Temporal(TemporalType.DATE)
        @Column(name = "BIRTH_DATE")
        public Date getBirthDate() {
            return birthDate;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }
        public void setVersion(int version) {
            this.version = version;
        }
        public String toString() {
            return "Singer - Id: " + id + ", First name: " + firstName
                    + ", Last name: " + lastName + ", Birthday: " + birthDate;
        }

}
