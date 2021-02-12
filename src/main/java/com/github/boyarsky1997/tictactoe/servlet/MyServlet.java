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
        TicTacToe game = new TicTacToe();
        game.initTable();
        HttpSession session = req.getSession(true);
        session.setAttribute("game", game);
        req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submit = req.getParameter("submit");
        String[] split = submit.split(",");
        HttpSession session = req.getSession(false);
        TicTacToe game = (TicTacToe) session.getAttribute("game");

        System.out.println(Arrays.toString(split));
        if (!game.isCellValid(Integer.parseInt(split[1]), Integer.parseInt(split[0]))) {
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }
        game.turnHuman(Integer.parseInt(split[1]), Integer.parseInt(split[0]));
        if (game.checkWinHuman()) {
            req.setAttribute("message", "You win!");
            req.setAttribute("isGameOver", true);
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }

        if (game.isTableFull()) {
            req.setAttribute("messages", "Sorry, DRAW!");
            req.setAttribute("isGameOver", true);
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);

            return;
        }

        game.turnAI();
        game.printTable();

        if (game.checkWinAI()) {
            req.setAttribute("message", "You lose!");
            req.setAttribute("isGameOver", true);
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }

        if (game.isTableFull()) {
            req.setAttribute("messages", "Sorry, DRAW!");
            req.setAttribute("isGameOver", true);
            req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/jsp/tictactoe.jsp").forward(req, resp);
    }
}