/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.entities;

/**
 *
 * @author mohamed
 */
public class User {
    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private int enabled;
    private String salt;
    private String password;
    private String confirmation_token;
    private String nom;
    private String adresse;
    private int telephone;  
    private String role;

    public User(int id, String username, String username_canonical, String email, String email_canonical, int enabled, String salt, String password, String confirmation_token, String nom, String adresse, int telephone) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.confirmation_token = confirmation_token;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public User() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    

}
