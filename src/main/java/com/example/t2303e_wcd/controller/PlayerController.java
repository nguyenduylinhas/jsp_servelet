package com.example.t2303e_wcd.controller;


import com.example.t2303e_wcd.dao.IndexerDAO;
import com.example.t2303e_wcd.dao.PlayerDAO;
import com.example.t2303e_wcd.model.Indexer;
import com.example.t2303e_wcd.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PlayerController")
    public class PlayerController extends HttpServlet {
        private  PlayerDAO playerDAO = new PlayerDAO();
        private  IndexerDAO indexerDAO = new IndexerDAO();
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Indexer> indexers = IndexerDAO.getAllIndexes();
            request.setAttribute("indexers", indexers);
            request.getRequestDispatcher("player/list.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getServletPath();

            switch (action) {
                case "addPlayer":
                    addPlayer(request, response);
                    break;
                case "editPlayer":
                    updatePlayer(request, response);
                    break;
                case "deletePlayer":
                    deletePlayer(request, response);
                    break;
            }
        }

//        private void listPlayers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
//            List<Player> players = playerDAO.getAllPlayers();
//            request.setAttribute("playerList", players);
//            request.getRequestDispatcher("player/list.jsp").forward(request, response);
//        }
//
//        private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            List<Indexer> indexes = indexerDAO.getAllIndexes();
//            request.setAttribute("indexList", indexes);
//            request.getRequestDispatcher("player/addPlayer.jsp").forward(request, response);
//        }

//        private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            int id = Integer.parseInt(request.getParameter("playerId"));
//            Player player = playerDAO.getPlayerById(id);
//            List<Indexer> indexes = indexerDAO.getAllIndexes();
//            request.setAttribute("player", player);
//            request.setAttribute("indexList", indexes);
//            request.getRequestDispatcher("player/editPlayer.jsp").forward(request, response);
//        }

        private void addPlayer(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String name = request.getParameter("name");
            String fullName = request.getParameter("fullName");
            String age = request.getParameter("age");
            int indexId = Integer.parseInt(request.getParameter("indexId"));

            Player newPlayer = new Player(name, fullName, age, indexId);
            playerDAO.savePlayer(newPlayer);
            response.sendRedirect("Player");
        }

        private void updatePlayer(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("playerId"));
            String name = request.getParameter("name");
            String fullName = request.getParameter("fullName");
            String age = request.getParameter("age");
            int indexId = Integer.parseInt(request.getParameter("indexId"));

            Player updatedPlayer = new Player(id, name, fullName, age, indexId);
            playerDAO.updatePlayer(updatedPlayer);
            response.sendRedirect("Player");
        }

        private void deletePlayer(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("playerId"));
            playerDAO.deletePlayer(id);
            response.sendRedirect("Player");
        }
    }

