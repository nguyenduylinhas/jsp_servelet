package com.example.t2303e_wcd.dao;

import com.example.t2303e_wcd.model.Player;
import com.example.t2303e_wcd.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    // Fetch all players with index details
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String query = "SELECT p.player_id, p.name, p.full_name, p.age, p.index_id, i.name AS index_name " +
                "FROM player p " +
                "JOIN indexer i ON p.index_id = i.index_id";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Player player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("name"),
                        resultSet.getString("full_name"),
                        resultSet.getString("age"),
                        resultSet.getInt("index_id"),
                        resultSet.getString("index_name")
                );
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    // Fetch a single player by ID
    public Player getPlayerById(int playerId) {
        Player player = null;
        String query = "SELECT p.player_id, p.name, p.full_name, p.age, p.index_id, i.name AS index_name " +
                "FROM player p " +
                "JOIN indexer i ON p.index_id = i.index_id " +
                "WHERE p.player_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("name"),
                        resultSet.getString("full_name"),
                        resultSet.getString("age"),
                        resultSet.getInt("index_id"),
                        resultSet.getString("index_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    // Insert a new player
    public void savePlayer(Player player) {
        String query = "INSERT INTO player (name, full_name, age, index_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, player.getName());
            statement.setString(2, player.getFullName());
            statement.setString(3, player.getAge());
            statement.setInt(4, player.getIndexId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update player information
    public void updatePlayer(Player player) {
        String query = "UPDATE player SET name = ?, full_name = ?, age = ?, index_id = ? WHERE player_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, player.getName());
            statement.setString(2, player.getFullName());
            statement.setString(3, player.getAge());
            statement.setInt(4, player.getIndexId());
            statement.setInt(5, player.getPlayerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a player by ID
    public void deletePlayer(int playerId) {
        String query = "DELETE FROM player WHERE player_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, playerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
