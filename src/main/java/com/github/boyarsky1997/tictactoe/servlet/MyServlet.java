package com.github.boyarsky1997.tictactoe.servlet;

import com.github.boyarsky1997.tictactoe.TicTacToe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initTable();
        HttpSession session = req.getSession(true);
        session.setAttribute("foo", ticTacToe);
        req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submit = req.getParameter("submit");
        String submit1 = req.getParameter("submit1");
        String[] split = submit.split(",");
        HttpSession session = req.getSession(false);
        TicTacToe ticTacToe = (TicTacToe) session.getAttribute("foo");

        System.out.println(Arrays.toString(split));
        ticTacToe.turnHuman(Integer.parseInt(split[1]), Integer.parseInt(split[0]));

        String[] strings = ticTacToe.checkWin(ticTacToe.getSIGN_X());
        if (strings != null) {
            System.out.println("Nagibator WIN!");
            String message = "Nagibator WIN!";
            req.setAttribute("message", message);
            req.setAttribute("foo", ticTacToe);
            ticTacToe.initTable();
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }

        if (ticTacToe.isTableFull()) {
            System.out.println("Sorry, DRAW!");
            String messages = "Sorry, DRAW!";
            req.setAttribute("messages", messages);
            ticTacToe.initTable();
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }

        ticTacToe.turnAI();
        ticTacToe.printTable();

        String[] strings1 = ticTacToe.checkWin(ticTacToe.getSIGN_O());
        if (strings1 != null) {
            System.out.println("Термінатор WIN!");
            String message = "Термінатор WIN!";
            req.setAttribute("message", message);
            req.setAttribute("foo", ticTacToe);
            ticTacToe.initTable();
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }

        if (ticTacToe.isTableFull()) {
            System.out.println("Sorry, DRAW!");
            String messages = "Sorry, DRAW!";
            req.setAttribute("messages", messages);
            ticTacToe.initTable();
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("foo", ticTacToe);
        req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
    }
}