package net.zylve.zutil.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

public final class CoordinatesManager {
    private static Connection connection;

    public static final void init(Connection connection) {
        CoordinatesManager.connection = connection;

        String statement = "CREATE TABLE IF NOT EXISTS zutil_coordinateconsents(target varchar(36), requesters TEXT);";

        try {
            PreparedStatement stmt = connection.prepareStatement(statement);
            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initPlayer(String uuid) {
        String statement = String.format("INSERT INTO zutil_coordinateconsents (target, requesters) SELECT '%s', '%s' WHERE NOT EXISTS (SELECT * FROM zutil_coordinateconsents WHERE target = '%s');",
                uuid, "", uuid);

        try {
            PreparedStatement stmt = connection.prepareStatement(statement);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public static final void addPlayer(String target, String requester) throws SQLException {
        String targetUUID = Bukkit.getPlayerExact(target).getUniqueId().toString();
        String requesterUUID = Bukkit.getPlayerExact(requester).getUniqueId().toString();
        String currentRequesters;
        String newRequesters;

        String requestersQuery = String.format("SELECT requesters FROM zutil_coordinateconsents WHERE target = '%s';", targetUUID);
        PreparedStatement rqstmt = connection.prepareStatement(requestersQuery);
        ResultSet rSet = rqstmt.executeQuery();

        if(rSet.next()) {
            currentRequesters = rSet.getString("requesters");
            
        } else {
            currentRequesters = "";
        }

        rqstmt.close();
        rSet.close();

        newRequesters = currentRequesters + requesterUUID + ";";

        String updateStatement = String.format("UPDATE zutil_coordinateconsents SET requesters = '%s' WHERE target = '%s'", newRequesters, targetUUID);

        try {
            PreparedStatement stmt = connection.prepareStatement(updateStatement);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static final void removePlayer(String target, String requester) {

    }

    public static final void getConsents(String target) {

    }

    public static final void clearConsents(String target) {
    }
}
