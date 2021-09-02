package kr.co.nandsoft.api.controller;

import kr.co.nandsoft.api.dao.SelectDao;
import kr.co.nandsoft.api.model.ApiResultVo;
import kr.co.nandsoft.api.model.SelectVo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class ServiceViewController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        SelectVo myvo = new SelectVo();
        SelectDao.DoSelect(myvo);

        request.setAttribute("result", SelectVo.getResult());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index3.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
