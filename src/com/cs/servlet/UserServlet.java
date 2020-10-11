package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String comm=request.getParameter("comm");
        if(comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
            UserServiceImpl usi = new UserServiceImpl();
            PageSupport ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(comm.equals("query")){
            UserServiceImpl usi=new UserServiceImpl();
            int ids=Integer.parseInt(id);
            User us= null;
            try {
                us = usi.findBySearchUserId(ids);
                if (us != null) {
                    request.getSession().setAttribute("us", us);
                    response.sendRedirect("show.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(comm.equals("del")){
            int ids=Integer.parseInt(id);
            UserServiceImpl usi=new UserServiceImpl();
            boolean flag=usi.delByUserID(ids);
            if (flag) {
                response.sendRedirect("index.jsp");
            }
            else{
                response.sendRedirect("list.jsp");
            }


        }
        /*
        if(comm.equals("update")){

        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}
