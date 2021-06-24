package Database;

import Models.User;

import java.sql.*;

public class Database {
    private Connection con;

    public void initDatabase(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + name);

            PreparedStatement pst = con.prepareStatement("PRAGMA foreign_keys = ON;");
            pst.executeUpdate();

            pst = con.prepareStatement(
                    "create table if not exists 'category' (" +
                    "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "'name' text UNIQUE ," +
                    "'description' text);"
            );
            pst.executeUpdate();

            pst = con.prepareStatement("create table if not exists 'product' (" +
                    "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "'name' text UNIQUE," +
                    "'description' text" +
                    "'producer' text" +
                    "'price' double," +
                    "'amount' double," +
                    "'category_id' Integer," +
                    "FOREIGN KEY(category_id) REFERENCES category(id)" +
                    ");"
            );
            pst.executeUpdate();

            pst = con.prepareStatement("create table if not exists 'users'" +
                    "( 'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "'login' text unique," +
                    "'password' text);");

            pst.executeUpdate();
            deleteAll();
        } catch (ClassNotFoundException e) {
            System.out.println("Can`t find driver JDBC");
            e.printStackTrace();
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("SQR query exception");
            e.printStackTrace();
        }
    }

// User
    public User insertUser(User user){
        try{
            PreparedStatement statement = con.prepareStatement("INSERT INTO users(login, password) VALUES (?, ?)");

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();
            ResultSet resSet = statement.getGeneratedKeys();
            user.setId(resSet.getInt("last_insert_rowid()"));
            statement.close();
            return user;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Problem with insert user", e);
        }
    }

    public User getUserByLogin(String login){
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM users where login = '" + login + "'");
            if(res.next())
                return new User(res.getInt("id"), res.getString("login"), res.getString("password"));
        } catch(SQLException e) {
            throw new RuntimeException("Can`t get user", e);
        }
        return null;
    }

    public void deleteAll() {
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM category");
            st.executeUpdate();
            st = con.prepareStatement("UPDATE 'sqlite_sequence' SET 'seq' = 0 WHERE name = 'category'");
            st.executeUpdate();

            st = con.prepareStatement("DELETE FROM product");
            st.executeUpdate();
            st = con.prepareStatement("UPDATE 'sqlite_sequence' SET 'seq' = 0 WHERE name = 'product'");
            st.executeUpdate();
            st = con.prepareStatement("DELETE FROM users");
            st.executeUpdate();
            st = con.prepareStatement("UPDATE 'sqlite_sequence' SET 'seq' = 0 WHERE name = 'users'");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem with DELETE from product", e);
        }
    }






}