package com.example.t2303e_wcd.dao;

import com.example.t2303e_wcd.model.Indexer;
import com.example.t2303e_wcd.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndexerDAO {

    // Fetch all indexes
    public static List<Indexer> getAllIndexes() {
        List<Indexer> indexes = new ArrayList<>();
        String query = "SELECT * FROM indexer";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Indexer index = new Indexer(
                        resultSet.getInt("index_id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("valueMin"),
                        resultSet.getFloat("valueMax")
                );
                indexes.add(index);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return indexes;
    }

    // Fetch a single index by ID
    public Indexer getIndexerById(int indexId) {
        Indexer index = null;
        String query = "SELECT * FROM indexer WHERE index_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, indexId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                index = new Indexer(
                        resultSet.getInt("index_id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("valueMin"),
                        resultSet.getFloat("valueMax")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return index;
    }
}
