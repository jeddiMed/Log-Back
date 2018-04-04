/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.IServices;

import pijava.entities.User;

/**
 *
 * @author mohamed
 */
public interface IUserServices {
    public Boolean Authentificate(String username, String password);
    public User Login(String username, String password);
}
