/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import models.PlayerModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moaaz
 */
public class DatabaseHandler {

    Connection connection = null;
    public static int playerID = 0;

    public DatabaseHandler() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/tic_tac_toe", "root", "root");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void endConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Done 
    public void addNewPlayer(PlayerModel player) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("INSERT INTO PLAYER VALUES(?,?,?,?,0,0)");
            pst.setInt(1, getLastID() + 1);
            pst.setString(2, player.getName());
            pst.setString(3, player.getUserName());
            pst.setString(4, player.getPassword());

            pst.addBatch();
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //endConnection();
        }
    }

    public int getLastID() {
        int lastID = 0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM PLAYER", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.last()) {
                lastID = resultSet.getInt("ID");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastID;
    }

    public boolean validatePlayer(String userName, String password) {
        boolean isValiedData = false;
        try {
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM PLAYER", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("USERNAME").equals(userName) && resultSet.getString("PASSWORD").equals(password)) {
                    isValiedData = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //endConnection();
        }
        return isValiedData;
    }

    //Get one player by specified Username
    public PlayerModel getPlayerByUsername(String userName) {
        try {
            //connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM PLAYER WHERE USERNAME = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, userName);
            ResultSet resultSet = pst.executeQuery();
            System.out.println(resultSet.first());
            if (resultSet.first()) {
                //Create player object and return it

                return new PlayerModel(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getInt("SCORE"),
                        resultSet.getInt("STATUS"));
            }
            //No player found with specified user name so return null
            return null;

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            //endConnection();
        }
    }

    public ArrayList<PlayerModel> getOnlinePlayers() {
        ArrayList<PlayerModel> onlinePlayers = new ArrayList();
        try {
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM PLAYER", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("STATUS") == 1) {
                    onlinePlayers.add(new PlayerModel(
                            resultSet.getInt("ID"),
                            resultSet.getString("NAME"),
                            resultSet.getString("USERNAME"),
                            resultSet.getString("PASSWORD"),
                            resultSet.getInt("SCORE"),
                            resultSet.getInt("STATUS"))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return onlinePlayers;
    }

    public void updateStatus(String userName, int status) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("UPDATE PLAYER SET STATUS = ? WHERE USERNAME = ?");
            pst.setInt(1, status);
            pst.setString(2, userName);

            pst.addBatch();
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //endConnection();
        }
    }

    public void updateScore(String userName, int newScore) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("UPDATE PLAYER SET SCORE = ? WHERE USERNAME = ?");
            pst.setInt(1, newScore);
            pst.setString(2, userName);

            pst.addBatch();
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //endConnection();
        }
    }

    public boolean isUsernameAlreadyUsed(String username) {
        try {
            String sql = "SELECT COUNT(*) FROM PLAYER WHERE USERNAME = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet resultSet = pst.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
