/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Services;

import pijava.Connection.DataSource;
import pijava.IServices.IUserServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;
import pijava.entities.User;

/**
 *
 * @author mohamed
 */
public class UserServices implements IUserServices{

    Connection conn;
    
    public UserServices(){
        conn= DataSource.getInstance().getConnection();
    }
    
    @Override
    public Boolean Authentificate(String username, String password) {
                Boolean u = false;
        int i=0;
        try {
            String query = "select password  from user where  (username = ? );";
            PreparedStatement stm = conn.prepareStatement(query);


            stm.setString(1, username);


            ResultSet rest = stm.executeQuery();

            while (rest.next()) {
                i++;
               String DBpassword = rest.getString("password");

                String hashedpassword = DBpassword.substring(0, 2) + 'a' + DBpassword.substring(3);
                boolean test = BCrypt.checkpw(password, hashedpassword);
                if (test) {
                    u = true;
                    System.out.println("Logged in with success");
                   // Main.actualpassword=password;
                } else {
                    u = false;
                    System.out.println("Wrong credentials");

                }

            }
            if(i==0){System.out.println("Could not find user ");}
        } catch (SQLException ex) {

    System.out.println("not good at all ");
        }
        return u ;
    }

    @Override
    public User Login(String username, String password) {
        boolean test = Authentificate(username,password);
        if(test){
            User user = new User();

            try {
            String query = "select * from user where  (username = ? );";
            PreparedStatement stm = conn.prepareStatement(query);

            stm.setString(1, username);


            ResultSet rest = stm.executeQuery();
            while (rest.next()) {

               user.setId(rest.getInt("id"));
               user.setEmail(rest.getString("email"));
               user.setNom(rest.getString("nom"));
               user.setAdresse(rest.getString("adresse"));
               user.setTelephone(rest.getInt("telephone"));
               user.setPassword(rest.getString("password"));
               String roleDB = rest.getString("roles");

                user.setUsername(username);
               if(roleDB.equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"))
               { user.setRole("ROLE_ADMIN");}
               else if (roleDB.equals("a:1:{i:0;s:11:\"ROLE_PARENT\";}"))
               { user.setRole("ROLE_PARENT");}
               else{ user.setRole("ROLE_USER"); }

                String DBpassword = rest.getString("password");






            }
        } catch (SQLException ex) {

            System.out.println("not good at all ");
        }


        return user;}
        else {return  null;}

    }
    
        public boolean addUser(User u) {
            try {
                String query = "insert into `user`(`username`, `username_canonical`, "
                        + "`email`, `email_canonical`, `enabled`, "
                        + "`password`, `last_login`,"
                        + " `roles`, `nom`, `adresse`,"
                        + " `telephone`  ) VALUES(?,?,?,?,?,?,?,?,?,?,?) ;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, u.getUsername());
                st.setString(2, u.getUsername());
                st.setString(3, u.getEmail());
                st.setString(4, u.getEmail());
                st.setString(5, "1");
                st.setString(6, this.hashPassword(u.getPassword()));
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                st.setString(7,dateFormat.format(date));
                st.setString(8, u.getRole());
                st.setString(9, u.getNom());
                st.setString(10, u.getAdresse());
                st.setString(11,String.valueOf(u.getTelephone()));
                              
                st.execute();
System.out.println("User added with success !");
            } catch (SQLException ex) {
                Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);

            }
return true;
    }

     public  String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(13);
        String thashed_password = BCrypt.hashpw(password_plaintext, salt);
        String hashed_password = thashed_password.substring(0, 2) + 'y' + thashed_password.substring(3);

        return(hashed_password);
    }
    
    
}
